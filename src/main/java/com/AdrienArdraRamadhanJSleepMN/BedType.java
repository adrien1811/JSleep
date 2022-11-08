package com.AdrienArdraRamadhanJSleepMN;


import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Enumeration class BedType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum BedType
{
    SINGLE,
    QUEEN,
    KING,
    DOUBLE;

    public static class Room extends Serializable
    {
        public int size;
        public String name;
        public int accountId;
        public Facility facility;
        public BedType bedType;
        public Price price;
        public String address;
        public City city;
        public ArrayList<Date> booked;

        public Room(int accountId, String name, int size, Price price, Facility facility, City city, String address){
            super();
            this.name = name;
            this.size = size;
            this.price = price;
            this.city = city;
            this.facility = facility;
            this.address = address;
            this.bedType = SINGLE;
            this.accountId = accountId;
            this.booked = new ArrayList<Date>();
        }
        public String toString(){
            return "Id : " + id
                    + "\n" + "Name : "
                    + name + "\n" + "Size : "
                    + size + "\n" + "Price : "
                    + price.price +"\n" + "Facility : "
                    + facility + "\n" + "City : "
                    + city + "\n" + "Address : "
                    + address
                    + "\n";
        }
        public Object write(){
            return null;
        }
        public boolean read(String A){
            return false;
        }
    }

    /**
     * Write a description of class Complaint here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    public static class Complaint extends Serializable
    {
        public String desc;
        public String date;

       public Complaint(int id, String date, String desc){
           super();
           this.desc = desc;
           this.date = date;
       }
       public String toString(){
           return "<< Complaint >> " + "\nId : " + id + "\nDate : " +
           date + "\nDescription : " + desc;
       }
    }
}
