package com.AdrienArdraRamadhanJSleepMN;


import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Enumeration class City - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum City
{
    SURABAYA,
    DEPOK,
    LAMPUNG,
    JAKARTA,
    BANDUNG,
    SEMARANG,
    MEDAN,
    BEKASI,
    BALI;

    public static class Renter extends Serializable
    {
        public static final String REGEX_NAME ="^[A-Z][A-Za-z0-9_]{4,20}$";
        public static final String REGEX_PHONE = "^[0-9]{9,12}$";
        public String username;
        public String address;
        public String phoneNumber;

        public Renter(String username, String phoneNumber, String address){
         super();
         this.username = username;
         this.address = address;
         this.phoneNumber = phoneNumber;
        }
        public boolean validate(){
                if(
                        this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE)){

                    return true;
                }

                return false;

            }
        }

    public static class Payment extends Algorithm.Invoice {

        private int roomId;
        public Date from;
        public Date to;



        public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
            super(buyerId, renterId);
            this.roomId = roomId;
            this.from = from;
            this.to = to;
        }

        public Payment(Algorithm.Account buyer, Renter renter, int roomId, Date from, Date to) {
            super(buyer, renter);
            this.roomId = roomId;
            this.from = from;
            this.to = to;
        }

        public int getRoomId() {
            return roomId;
        }

        public static boolean makeBooking(Date from, Date to, BedType.Room room){
            if(availability(from, to, room)){
                Calendar start = Calendar.getInstance();
                start.setTime(from);
                Calendar end = Calendar.getInstance();
                end.setTime(to);
                for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                    room.booked.add(date);
                }
                return true;
            }
            return false;
        }

        public static boolean availability(Date from, Date to, BedType.Room room){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            if(start.after(end) || start.equals(end)){
                return false;
            }
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                if(room.booked.contains(date)){
                    return false;
                }
            }
            return true;
        }

        public String getTime(){
            SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date' = dd MMMM yyyy");
            String currTime = SDFormat.format(time.getTime());
            return currTime;
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
}
