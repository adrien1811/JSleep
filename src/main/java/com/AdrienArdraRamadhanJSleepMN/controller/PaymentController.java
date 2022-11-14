package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.*;
import com.AdrienArdraRamadhanJSleepMN.Account;
import com.AdrienArdraRamadhanJSleepMN.dbjson.*;
import org.springframework.web.bind.annotation.*;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    )throws ParseException{
        double price;
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        price = room.price.price;
        if (buyer == null || room == null || buyer.balance <= price || !Payment.availability(fromDate, toDate, room)) {
            return null;
        }
        Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
        buyer.balance -= room.price.price;
        payment.status = Invoice.PaymentStatus.WAITING;
        if(Payment.makeBooking(fromDate, toDate, room)) {
            paymentTable.add(payment);
            return payment;
        }
        else{
            return null;
        }
    }
    @PostMapping("/cancel")
    public boolean cancel(
            @PathVariable int id
    ) {
        Payment payment = Algorithm.<Payment>find(paymentTable, payment1 -> payment1.id == id);
        if (payment == null || payment.status != Invoice.PaymentStatus.WAITING) {
            return false;
        }
        else{
            Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.getRoomId());
            buyer.balance += room.price.price;
            payment.status = Invoice.PaymentStatus.FAILED;
            return true;
        }
    }
    @PostMapping("/accept")
    public boolean accept(
            @PathVariable int id
    ) {
        Payment payment = Algorithm.<Payment>find(paymentTable, payment1 -> payment1.id == id);
        if(payment == null || payment.status != Invoice.PaymentStatus.WAITING){
            return false;
        }
        else{
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
    }
    @PostMapping("/submit")
    public boolean submit(
            @RequestParam int id
    )
    {
        return false;
    }

}