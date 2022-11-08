package com.AdrienArdraRamadhanJSleepMN;
import java.util.Date;

public class Invoice extends Serializable
{
    public Date time;
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;

    protected Invoice(int id, int buyerId){
        super();
        this.renterId = renterId;
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.buyerId = buyerId;
    }
    public Invoice(Account buyer, Renter renter){
        super();
        this.time = new Date();
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
                + time + "\n"
                + "Room Rating : "
                + rating + "\n" + "Payment Status :"
                + status + "\n";
    }

}