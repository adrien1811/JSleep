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
        return ((Integer)this.id).compareTo(val.id);
    }
    public <T> Integer setClosingId(Class<T> setter, int number){
        return mapCounter.replace(setter, number);
    }

    public <T> Integer getClosingId(Class<T> getter){
        return mapCounter.get(getter);
    }

    public boolean equals(Object val){
        return (val instanceof Serializable && ((Serializable) val).id == this.id);
    }

    public boolean equals(Serializable val){
        return val.id == this.id;
    }
}