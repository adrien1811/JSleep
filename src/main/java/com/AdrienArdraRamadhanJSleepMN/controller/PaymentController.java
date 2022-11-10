package com.AdrienArdraRamadhanJSleepMN.controller;
import com.AdrienArdraRamadhanJSleepMN.Account;
import com.AdrienArdraRamadhanJSleepMN.Payment;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "src/json/json.payment")
    public static JsonTable<Account> paymentTable;

    @Override
    public JsonTable<Payment> getJsonTable() {
        return null;
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    )
    {
        return null;
    }
    @PostMapping("payment/submit")
    public boolean submit(@RequestParam int id) {
        return false;
    }

    @PostMapping("payment/accept")
    public boolean accept(@RequestParam int id) {
        return false;
    }

    @PostMapping("payment/cancel")
    public boolean cancel(@RequestParam int id) {
        return false;
    }
}