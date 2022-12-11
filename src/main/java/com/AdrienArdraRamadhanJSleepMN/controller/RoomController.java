package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.*;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import com.AdrienArdraRamadhanJSleepMN.dbjson.*;
import com.AdrienArdraRamadhanJSleepMN.Room;

import java.util.ArrayList;
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
    List<Room> getRoomByRenter(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }
    @PostMapping("/create")
    public Room create(@RequestParam int accountId,@RequestParam String name,@RequestParam int size, @RequestParam int price, @RequestParam ArrayList<Facility> facility, @RequestParam City city, @RequestParam String address, @RequestParam BedType bedType){
        Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if (acc != null) {
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            roomTable.add(room);
            return room;
        }else
            return null;
    }
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}