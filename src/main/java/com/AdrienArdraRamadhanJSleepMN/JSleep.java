package com.AdrienArdraRamadhanJSleepMN;
import java.util.List;

import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;
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
            JsonTable<Algorithm.Account> tableAccount = new JsonTable<>(Algorithm.Account.class, filepath);
            tableAccount.add(new Algorithm.Account("name", "email", "password"));
            tableAccount.writeJson();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        try {
            String filepath = "C:\\Users\\ADRIEN\\OneDrive\\Kuliah smt 3\\OOP\\CS\\JSleep\\src\\json\\randomRoomList.json";
            JsonTable<BedType.Room> tableRoom = new JsonTable<>(BedType.Room.class, filepath);
            List<BedType.Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        for(int i=0; i<10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }
        Algorithm.Account testRegex = new Algorithm.Account("Adrien Ardra Ramadhan","adrienardra@gmail.com", "Adrien123");
        Algorithm.Account testRegexFail =new Algorithm.Account("Adrien Ardra Ramadhan","adrien-ardra-ramadhan@gmail.com", "adrien100");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());
    }

    public static BedType.Room createRoom(){
        Price price = new Price(10000.0, 10);
        BedType.Room room = new BedType.Room(2, "Restaurant", 35, price, Facility.AC, City.BALI, "Jl. jalan");
        return room;
    }
    public static List<BedType.Room> filterByPrice(List<BedType.Room> list, double minPrice, double maxPrice){
        return Algorithm.<BedType.Room>collect(list, room -> room.price.price >= minPrice && room.price.price <= maxPrice);
    }
    public static List<BedType.Room> filterByAccountId(List<BedType.Room> list, int accountId, int page, int pageSize){
        return Algorithm.<BedType.Room>paginate(list,page,pageSize, room -> room.accountId == accountId);
    }

    public static List<BedType.Room> filterByCity(List<BedType.Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }
}