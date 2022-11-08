package com.AdrienArdraRamadhanJSleepMN;
import java.util.List;

import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonDBEngine;

public class JSleep {
    @SpringBootApplication
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
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