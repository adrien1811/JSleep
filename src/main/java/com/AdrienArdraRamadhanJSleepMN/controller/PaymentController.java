package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.JsonTable;
import com.AdrienArdraRamadhanJSleepMN.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.GetMapping;
public class PaymentController {

    public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERED_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;

    @JsonAutowired(filepath = "C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\jsonFiles\\randomProductList.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;


    @PostMapping("/payment")
    public boolean accept (int id) {
        return false;
    }

    @PostMapping("/payment")
    public boolean cancel (int id) {
        return false;
    }

    @PostMapping("/payment")
    public Payment create (int id) {
        return null;
    }

    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/payment")
    public boolean submit (int id, String receipt) {
        return false;
    }

    @PostMapping("/payment")
    private static boolean timekeeper (Payment payment) {
        return false;
    }

    @PostMapping("/create")
    public PaymentController create() {
        return null;
    }

    @PostMapping("/{id}/accept")
    public PaymentController accept() {
        return null;
    }

    @PostMapping("/{id}/cancel")
    public PaymentController cancel() {
        return null;
    }

    @PostMapping("/{id}/submit")
    public PaymentController submit() {
        return null;
    }
}