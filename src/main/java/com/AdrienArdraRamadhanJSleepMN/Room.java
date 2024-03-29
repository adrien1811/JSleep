package com.AdrienArdraRamadhanJSleepMN;
import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;
import com.AdrienArdraRamadhanJSleepMN.Facility;
import java.util.ArrayList;
import java.util.Date;
/**
 * Room class
 * This class is used to represent a room
 * @author Adrien Ardra
 * @see Serializable
 */
public class Room extends Serializable
{
    public int size;
    public String name;
    public int accountId;
    public ArrayList<Facility> facility;
    public BedType bedType;
    public Price price;
    public String address;
    public City city;
    public ArrayList<Date> booked;

    public Room(int accountId, String name, int size, Price price,ArrayList<Facility> facility, City city, String address,BedType bedType){
        super();
        this.name = name;
        this.size = size;
        this.price = price;
        this.city = city;
        this.facility = facility;
        this.address = address;
        this.bedType = bedType;
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