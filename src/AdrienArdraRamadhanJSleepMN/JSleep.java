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

        /**
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        for (int i = 0; i < 5; i++) {
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
    }
    public static Room createRoom(){
        Price price = new Price(200000, 15);
        Room room = new Room(1234, "hotel", 20, price,
                Facility.WiFi, City.DEPOK, "JL. Margonda Raya");
        return room;
    }
         **/
        String filepath= "C:\\Users\\ADRIEN\\OneDrive\\Kuliah smt 3\\OOP\\CS\\JSleep\\src\\lib\\city.json";
        Gson gson = new Gson();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states:");
            input.listOfStates.forEach(state -> System.out.println(state));
            }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    }