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
    public static Room createRoom(){
        Price price = new Price(200000, 15);
        Room room = new Room(1234, "hotel", 20, price,
                Facility.WiFi, City.DEPOK, "JL. Margonda Raya");
        return room;
    }
}