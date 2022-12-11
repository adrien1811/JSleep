package com.AdrienArdraRamadhanJSleepMN;
/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;

import java.util.regex.Pattern;
public class Renter extends Serializable
{
    public static final String REGEX_NAME ="^[A-Z][A-Za-z0-9_]{4,20}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    public String username;
    public String address;
    public String phoneNumber;

    public Renter(String username, String phoneNumber, String address){
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public boolean validate(){
        if(
                this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE)){

            return true;
        }

        return false;

    }
}