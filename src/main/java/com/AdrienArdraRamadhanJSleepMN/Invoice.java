package com.AdrienArdraRamadhanJSleepMN;
import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;

public class Invoice extends Serializable
{

    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;

    protected Invoice(int id, int buyerId){
        super();
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyerId;
    }
    public Invoice(Account buyer, Renter renter){
        super();
        this.renterId = renter.id;
        this.buyerId = buyer.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }

    public String print(){
        return "id : "
                + id
                + "\n" + "buyerId : "
                + buyerId + "\n" + "renterId : "
                + renterId + "\n" + "time : "
                + "Room Rating : "
                + rating + "\n" + "Payment Status :"
                + status + "\n";
    }

}