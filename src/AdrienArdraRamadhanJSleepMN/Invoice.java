package AdrienArdraRamadhanJSleepMN;
import java.util.Date;

public class Invoice extends Serializable
{
   public int buyerId;
   public int renterId;     
   public Date time;
   public RoomRating rating;
   public PaymentStatus status;
   
   protected Invoice(int id, int buyerId, int renterId){
       super(id);
       this.buyerId = buyerId;
       this.renterId = renterId;
       this.time = new Date();
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
   }
   public Invoice(int id, Account buyer, Renter renter){
       super(id);
       this.time = new Date();
       this.buyerId = buyer.id;
       this.renterId = renter.id;
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
   }
   public enum RoomRating{
       NONE, BAD, NEUTRAL, GOOD
   }
   public enum PaymentStatus{
       FAILED, WAITING, SUCCESS
   }
   public String print(){
       return "id : " + id + "\n" + "buyerId : " + buyerId + "\n" + "renterId : " + renterId + "\n" + "time : " + time + "\n" + "Room Rating : " + rating + "\n" + "Payment Status :" + status + "\n";
   }
    
}