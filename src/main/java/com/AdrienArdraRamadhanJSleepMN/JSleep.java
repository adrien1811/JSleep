package com.AdrienArdraRamadhanJSleepMN;
import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class JSleep {
    @SpringBootApplication
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args) {
        SpringApplication.run(JSleep.class, args);
        /** Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Jalan");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate()); **/
        try{
            String filepath = "C:\\Users\\ADRIEN\\OneDrive\\Kuliah smt 3\\OOP\\CS\\JSleep\\src\\json\\account.json.txt";
            JsonTable <Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            tableAccount.writeJson();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        try {
            String filepath = "C:\\Users\\ADRIEN\\OneDrive\\Kuliah smt 3\\OOP\\CS\\JSleep\\src\\json\\randomRoomList.json";
            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        for(int i=0; i<10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }
        Account testRegex = new Account("Adrien Ardra Ramadhan","adrienardra@gmail.com", "Adrien123");
        Account testRegexFail =new Account("Adrien Ardra Ramadhan","adrien-ardra-ramadhan@gmail.com", "adrien100");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());
    }

    public static Room createRoom(){
        Price price = new Price(10000.0, 10);
        Room room = new Room(2, "Restaurant", 35, price, Facility.AC, City.BALI, "Jl. jalan");
        return room;
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(list,room -> room.price.price >= minPrice && room.price.price <= maxPrice);
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.accountId == accountId);
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }
}