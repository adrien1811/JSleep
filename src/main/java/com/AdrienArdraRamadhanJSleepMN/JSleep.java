package com.AdrienArdraRamadhanJSleepMN;
import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonDBEngine;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.AdrienArdraRamadhanJSleepMN.dbjson.JsonTable;


@SpringBootApplication
public class JSleep {

   /*class Country {
       public String name;
       public int population;
       public List<String> listOfStates;
   }*/

    public static void main(String[] args) {
        SpringApplication.run(JSleep.class, args);
        JsonDBEngine.Run(JSleep.class);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}





