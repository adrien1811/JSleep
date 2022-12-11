package com.AdrienArdraRamadhanJSleepMN;


import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;

/**
 * This class is used to store the information of a complaint.
 * @author Adrien Ardra
 * @see Serializable
 */
public class Complaint extends Serializable
{
    public String desc;
    public String date;

    public Complaint(int id, String date, String desc){
        super();
        this.desc = desc;
        this.date = date;
    }
    public String toString(){
        return "<< Complaint >> " + "\nId : " + id + "\nDate : " +
                date + "\nDescription : " + desc;
    }
}