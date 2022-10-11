package AdrienArdraRamadhanJSleepMN;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar; 

public class Payment extends Invoice
{
    public Date from;
    public Date to;
    private int roomId;
    
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(id, buyer, renter);
        this.to = to;
        this.roomId = roomId;
        this.from = from;
    }

    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(id, buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }
    
    public String print()
    {
        return ("Room ID: "
                + this.roomId
                + "\n"
                +
                "Payment from: "
                + this.from
                + "\n"
                + "Payment to: "
                + this.to
                + "\n");
    }
    public int getRoomId()
    {
        return roomId;
    }
    public String getTime() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date = 'dd MMMM yyyy");
        String formattedFrom = SDFormat.format(from.getTime());
        return formattedFrom;
    }
    public static boolean availability(Date from, Date to, Room room)
    {
        if(room.booked.isEmpty())
        {
            return true;
        }
        if(to.before(from))
            return false;
        for(Date j : room.booked)
        {
            if(j.after(from) && j.before(to) || j.equals(from)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean makeBooking(Date from, Date to, Room room)
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String bookingFrom = SDFormat.format(from.getTime());
        Calendar calendar = Calendar.getInstance();
        String bookingTo = SDFormat.format(to.getTime());
        calendar.setTime(from);
        if(availability(from, to, room)){
            while(from.before(to)){
                room.booked.add(from);
                calendar.setTime(from);
                calendar.add(Calendar.DATE, 1);
                from = calendar.getTime();
            }
            return true;
        }
        else
        {
            return false;
        }
    }

}
