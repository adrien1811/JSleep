package com.AdrienArdraRamadhanJSleepMN.controller;
import java.util.List;
import com.AdrienArdraRamadhanJSleepMN.*;
import com.AdrienArdraRamadhanJSleepMN.dbjson.*;
import com.AdrienArdraRamadhanJSleepMN.Room;
import org.springframework.web.bind.annotation.*;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonAutowired;


@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @GetMapping ("/{id}/isUsed")
    boolean isUsed (@PathVariable int id, @RequestParam double price){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.isUsed();
    }
    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }
    @GetMapping ("/getAvailable ")
    List<Voucher> getAvailable (@RequestParam int page, @RequestParam int size){
        return Algorithm.<Voucher>paginate(voucherTable, page, size, pred -> !pred.isUsed());
    }
    @JsonAutowired(value = Voucher.class, filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;
    @GetMapping ("/{id}/canApply ")
    boolean canApply (
            @PathVariable int id,
            @RequestParam double price
    )
    {
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        if(voucher == null){
            return false;
        }
        else{
            return voucher.canApply(new Price(price));
        }
    }
}