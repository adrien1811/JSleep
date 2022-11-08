package com.AdrienArdraRamadhanJSleepMN;


public class Account extends Serializable {

    public String name;
    public String email;
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