package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.Algorithm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.regex.Pattern;
import com.AdrienArdraRamadhanJSleepMN.Algorithm.Account;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;
import com.AdrienArdraRamadhanJSleepMN.Renter;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController
{
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private JsonTable<Account> accountTable;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@{1}[a-zA-Z]+\\.{1}[.a-zA-Z]*[a-zA-Z]$";
    public Pattern REGEX_PATTERN_PASSWORD=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    public Pattern REGEX_PATTERN_EMAIL;
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password);
    }


    public AccountController() throws IOException {
        accountTable = new JsonTable<Account>(Account.class, "Account.json");
    }

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        return new Renter(username, address, phoneNumber);
    }



    boolean topUp(@PathVariable int id, @RequestParam double balance){
        return true;
    }
}
