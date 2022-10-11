package AdrienArdraRamadhanJSleepMN;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public BedType bedType;
    public Price price;
    public String address;
    public City city;
    public ArrayList<Date> booked;
    
    public Room(int i, String name, int size, Price price, Facility facility, City city, String address){
        super();
        this.name = name;
        this.size = size;
        this.price = price;
        this.city = city;
        this.facility = facility;
        this.address = address;
        this.bedType = BedType.SINGLE;
        this.booked = new ArrayList<Date>();
    }
    public String toString(){
        return "Id : " + id
                + "\n" + "Name : "
                + name + "\n" + "Size : "
                + size + "\n" + "Price : "
                + price.price +"\n" + "Facility : "
                + facility + "\n" + "City : "
                + city + "\n" + "Address : "
                + address
                + "\n";
    }
    public Object write(){
        return null;
    }
    public boolean read(String A){
        return false;
    }
}
