package AdrienArdraRamadhanJSleepMN;
import java.util.ArrayList;

public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList array = new ArrayList();
        for(Price lis : list){
            if(lis.price <= value && less)
            {
                array.add(lis.price);
            }
            else if(lis.price > value && !less)
            {
                array.add(lis.price);
            }
        }
        return array;
    }
}