package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.JsonTable;
import com.AdrienArdraRamadhanJSleepMN.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
public class PaymentController {


    @PostMapping("/{create}")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
            ){
        return null;
    }
    @PostMapping("/{accept}")
    public Payment accept (){
        return null;
    }
    @PostMapping("/{cancel}")
    public Payment cancel (){
        return null;
    }
    @PostMapping("/{submit}")
    public Payment submit (){
        return null;
    }

}