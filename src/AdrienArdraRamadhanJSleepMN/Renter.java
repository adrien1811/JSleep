package AdrienArdraRamadhanJSleepMN;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    public String username;
    public String address;
    public int phoneNumber;
    Renter(int id, String username){
        super();
        this.username = username;
    }
    Renter(int id, String username, String address){
        super();
        this.username = username;
    }
    Renter(int id, String username, int phoneNumber){
        super();
        this.username = username;
    }
    Renter(int id, String username, int phoneNumber, String address){
        super();
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
