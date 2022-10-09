package AdrienArdraRamadhanJSleepMN;
import java.sql.*;


public class JSleep
{
  public static void main(String[] args){
      Room RoomA = JSleep.createRoom();
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
  }
  
  public static Room createRoom(){
      Price price = new Price(200000, 15);
      Room room = new Room(1234, "hotel", 20, price, 
    Facility.WiFi, City.DEPOK, "JL. Margonda Raya");
      return room;
  }

  /*
   * Price price = new Price(200000, 15);
      Room room = new Room("hotel", 20, price, Facility.WiFi);
      return room;
  public static Account createAccount(){
      Account account = new Account("Azzah","azzah.azkiyah@ui.ac.id", "tutam");
      return account;
  }
  
  public static Price cekHarga(){
      Price harga = new Price(250, 10);
      Voucher promo = new Voucher("Deluxe",00123, Type.DISCOUNT, 100, 10);
      return harga;
  }*/
}