package AdrienArdraRamadhanJSleepMN;
import java.util.ArrayList;

public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList arr = new ArrayList();
        for(Price lis : list){
            if(lis.price <= value && less){
                arr.add(lis.price);
            }
            else if(lis.price > value && !less){
                arr.add(lis.price);
            }
        }
        return arr;
    }
}