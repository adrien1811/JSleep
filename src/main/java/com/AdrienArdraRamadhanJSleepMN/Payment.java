package com.AdrienArdraRamadhanJSleepMN;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice {

    private int roomId;
    public Date from;
    public Date to;



    public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public int getRoomId() {
        return roomId;
    }

    public static boolean makeBooking(Date from,Date to,Room room){

        return true;
    }

    public static boolean availability(Date from,Date to,Room room){

        return true;
    }

    @Override
    public String print(){
        return "Payment{" +
                "roomId=" + roomId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}
