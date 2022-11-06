package com.AdrienArdraRamadhanJSleepMN;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price
{
    // instance variables - replace the example below with your own
    public double rebate;
    public double price;
    public double discount;

    public Price(double price){
        this.discount = 0;
        this.price = price;
    }
    public Price(double price,double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public String toString(){
        return "<< Price >>" + "\nPrice : " + price +
                "\ndiscount :" + discount;
    }
    /* private double getDiscountedPrice(){
        if(discount >= 100.0){
            return 100.0;
        }
        else if(discount == 100.0){
            return 0;
        }
        else{
            return price - ((double)price*(((double)discount)/100.0));
        }
    }
    
    private double getRebatedPrice(){
        if(rebate > price){
            rebate=price;
        }
        return price - rebate;
    }
    
    */
}

