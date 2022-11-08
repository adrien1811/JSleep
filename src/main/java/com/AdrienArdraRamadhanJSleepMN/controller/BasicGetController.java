package com.AdrienArdraRamadhanJSleepMN.controller;

import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
public interface BasicGetController<T extends Serializable> {
    public default T getById(@PathVariable int id){
            return getJsonTable().get(id);
            }
     public abstract JsonTable<T> getJsonTable();
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize){
            return getJsonTable().subList(page,page + pageSize);
            }
    }


