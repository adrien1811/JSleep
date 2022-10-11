package AdrienArdraRamadhanJSleepMN;
import java.sql.*;
import java.util.ArrayList;


public class JSleep
{
    public static void main(String[] args) {
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        for (int i = 0; i < 5; i++) {
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
    }

      /*Room RoomA = JSleep.createRoom();
      Room RoomB = JSleep.createRoom();
      System.out.println("Membuat booking dari tanggal 15 hingga 18");
      Date start = Date.valueOf("2022-8-15");
      Date end = Date.valueOf("2022-8-20");
      System.out.println(Payment.makeBooking(start, end,RoomA));
      System.out.println("Membuat booking dari tanggal 15 hingga 18");
      Date start2 = Date.valueOf("2022-8-18");
      Date end2 = Date.valueOf("2022-8-20");
      System.out.println(Payment.makeBooking(start2, end2,RoomA));
      System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
      Date start3 = Date.valueOf("2022-8-18");
      Date end3 = Date.valueOf("2022-8-20");
      System.out.println(Payment.makeBooking(start3, end3,RoomB));

       */



    public static Room createRoom(){
        Price price = new Price(200000, 15);
        Room room = new Room(1234, "hotel", 20, price,
                Facility.WiFi, City.DEPOK, "JL. Margonda Raya");
        return room;
    }


}