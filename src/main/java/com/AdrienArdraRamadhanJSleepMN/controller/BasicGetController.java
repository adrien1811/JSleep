package com.AdrienArdraRamadhanJSleepMN.controller;


import java.util.List;
import com.AdrienArdraRamadhanJSleepMN.Algorithm;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;
import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public interface BasicGetController<T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/{page}")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int size
    )
    {
        final JsonTable<T> table = getJsonTable();
        return Algorithm.<T>paginate(getJsonTable(), page, size, pred -> true);
    }
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ) {
        return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
    }
}


