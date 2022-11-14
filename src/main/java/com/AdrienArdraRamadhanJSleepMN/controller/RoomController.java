package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.*;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import com.AdrienArdraRamadhanJSleepMN.dbjson.*;
import com.AdrienArdraRamadhanJSleepMN.Room;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }
    @JsonAutowired(value = Room.class, filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;
    @GetMapping ("/{id}/renter")
    List<Room> getRoomByRenter(@PathVariable int id, @RequestParam int page, @RequestParam int size){
        return Algorithm.<Room>paginate(getJsonTable(), page, size, pred -> pred.accountId == id);
    }
    @GetMapping ("/create")
    public Room create (@RequestParam int accountId, @RequestParam String name,
                        @RequestParam int size, @RequestParam int price, @RequestParam Facility facility,
                        @RequestParam City city, @RequestParam String address){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId);
        if(account==null){
            return null;
        }
        else{
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address);
            roomTable.add(room);
            return room;
        }
    }
}