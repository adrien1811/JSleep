package AdrienArdraRamadhanJSleepMN;
import java.util.HashMap;
public class Serializable {

    public final int id;
    private static HashMap<Class <?>, Integer> mapCounter = new HashMap<Class <?>, Integer>();

    protected Serializable(){
        int idCount = 0;
        this.id = idCount;
        idCount++;
    }
    public int CompareTo(Serializable val){
        return id - this.id;
    }
    public <T> Integer setClosingId(Class<T> setter, int number){

        return mapCounter.replace(setter, number);
    }

    public <T> Integer getClosingId(Class<T> getter){

        return mapCounter.get(getter);
    }

    public boolean equals(Object val){
        if (val == null) {
            return false;
        } else if (val instanceof Serializable) {

            return id == ((Serializable) val).id;
        }
        return super.equals(val);
    }

    public boolean equals(Serializable val){
        return val.id == this.id;
    }
}