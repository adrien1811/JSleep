package com.AdrienArdraRamadhanJSleepMN.controller;
import com.AdrienArdraRamadhanJSleepMN.Algorithm;
import com.AdrienArdraRamadhanJSleepMN.Account;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.NoSuchAlgorithmException;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;
import com.AdrienArdraRamadhanJSleepMN.Renter;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{

    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@{1}[a-zA-Z]+\\.{1}[.a-zA-Z]*[a-zA-Z]$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    @JsonAutowired(value = Account.class, filepath = "C:\\Users\\ADRIEN\\OneDrive\\Kuliah smt 3\\OOP\\CS\\JSleep\\src\\main\\java\\com\\AdrienArdraRamadhanJSleepMN\\json\\account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    @Override
    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

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
        if (!name.isBlank() || REGEX_PATTERN_EMAIL.matcher(email).matches() || REGEX_PATTERN_PASSWORD.matcher(password).matches()){
            String enc = null;
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] Byte = md.digest(password.getBytes());
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < Byte.length; i++){
                    builder.append(Integer.toString((Byte[i] & 0xff) + 0x100, 16).substring(1));
                }
                enc = builder.toString();
            }
            catch (NoSuchAlgorithmException t){
                t.printStackTrace();
            }
            String encrypted = enc;
            Account acc = new Account(name, email, encrypted);
            accountTable.add(acc);
            return acc;
        }
        else{
            return null;
        }
    }
    @PostMapping("{id}/registerRenter")
    public Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address, @RequestParam String phoneNumber){
        for(Account account : accountTable){
            if(account.id == id){
                Renter renter = new Renter(username, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        }
        return null;
    }
    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        String enc = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] Byte = md.digest(password.getBytes());
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < Byte.length; i++){
                builder.append(Integer.toString((Byte[i] & 0xff) + 0x100, 16).substring(1));
            }
            enc = builder.toString();
        }
        catch (NoSuchAlgorithmException t){
            t.printStackTrace();
        }
        String encrypted = enc;
        for(Account acc : getJsonTable()){
            if (acc.email.equals(email) && acc.password.equals(encrypted)){
                return acc;
            }
        }
        return null;
    }

    @PostMapping("{id}/topUp")
    boolean topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        Account acc = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(acc != null){
            acc.balance = balance + acc.balance;
            return true;
        }
        else {
            return false;
        }
    }
}