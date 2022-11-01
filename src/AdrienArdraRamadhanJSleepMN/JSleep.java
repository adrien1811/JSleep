package AdrienArdraRamadhanJSleepMN;
import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;


public class JSleep
{
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args) {
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        for (int i = 0; i < 5; i++) {
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }

    }
    public static Room createRoom(){
        Price price = new Price(200000, 15);
        Room room = new Room(1, "hotel", 20, price,
                Facility.WiFi, City.DEPOK, "JL. Margonda Raya");
        return room;
    }
    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){

    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){

    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){

    }
    }
