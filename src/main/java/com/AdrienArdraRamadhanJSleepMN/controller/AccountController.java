package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.Account;
import com.AdrienArdraRamadhanJSleepMN.Algorithm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
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

        for (Account account : accountTable){
            if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                return null;
            }
        }
        String hashedPasword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hashedPasword = sb.toString();
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        accountTable.add(new Account(name, email, hashedPasword));
        return new Account(name, email, hashedPasword);
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
    )
    {
        return new Renter(username, address, phoneNumber);
    }
    boolean topUp(@PathVariable int id, @RequestParam double balance){
        return true;
    }
}
