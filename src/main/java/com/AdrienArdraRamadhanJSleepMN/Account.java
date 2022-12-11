package com.AdrienArdraRamadhanJSleepMN;


import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;
/**
 * This class is used to store the information of a user account.
 * @author Adrien Ardra
 * @see Serializable
 */

public class Account extends Serializable {

    public String name;
    public String email;
    public double balance;

    public Renter renter;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@{1}[a-zA-Z]+\\.{1}[.a-zA-Z]*[a-zA-Z]$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public String password;
    /** public Account(int id, String name, String email, String password){
     super();
     this.name = name;
     this.email = email;
     this.password = password;
     } **/
    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    /**
     * This method is used to validate the email and password of the account.
     * @author Adrien Ardra
     * @return Returns true if the email and password are valid.
     */
    public boolean validate(){
        if(this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)){
            return true;
        }
        return false;
    }
    public String toString(){
        return "<< Account >>" + "\nName : " + name +
                "\nEmail : " + email +
                "\nPassword : " + password;
    }
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
}