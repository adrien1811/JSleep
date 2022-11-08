package com.AdrienArdraRamadhanJSleepMN;

import com.AdrienArdraRamadhanJSleepMN.dbjson.Serializable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

public class Algorithm {
    private Algorithm() {
    }

    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while (iterator.hasNext())
            if (pred.predicate(iterator.next()))
                ++count;
        return count;
    }

    public static <T> T find(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return current;
        }
        return null;
    }

    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return true;
        }
        return false;
    }

    public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        ArrayList<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                list.add(current);
        }
        return list;
    }

    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);
        // skip first occurrences of element
        while (iterator.hasNext() && occurences < startingIdx) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                ++occurences;
        }
        // get the next occurrences of element
        while (iterator.hasNext() && pageList.size() < pageSize) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                pageList.add(obj);
        }
        return pageList;
    }

    /**
     * Write a description of class Voucher here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    public abstract static class Voucher extends Serializable
    {
        public Type type;
        public double cut;
        public String name;
        public int code;
        public double minimum;
        private boolean used;

        public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut){
            super();
            this.used = used;
            this.type = type;
            this.cut = cut;
            this.name = name;
            this.code = code;
            this.minimum = minimum;
        }
        public boolean canApply(Price price){

            if( price.price > minimum && this.used == false){
                return true;
            }
            else{
                return false;
            }
        }
        public double apply(Price price){
            this.used = true;

            if(this.type == Type.DISCOUNT){
                if(cut >= 100){
                    cut = 100;
                }
                return price.price - (price.price * cut)/10;
            }
            else{
                if(cut >= price.price){
                    cut = price.price;
                }
                return price.price-=cut;
            }

        }
        public boolean isUsed(){
            return (boolean) used;
        }
    }

    public static class Invoice extends Serializable
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
       public Invoice(Account buyer, City.Renter renter){
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

    @SpringBootApplication
    public static class AdrienArdraRamadhanJSleepMnApplication {

        public static void main(String[] args) {
            SpringApplication.run(AdrienArdraRamadhanJSleepMnApplication.class, args);
        }

    }

    public static class Account extends Serializable {

        public String name;
        public String email;
        public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@{1}[a-zA-Z]+\\.{1}[.a-zA-Z]*[a-zA-Z]$";
        public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        public String password;
        /** public Account(int id, String name, String email, String password){
            super();
            this.name = name;
            this.email = email;
            this.password = password;
        } **/
        public Account(String name, String email, String password){
            this.name = name;
            this.email = email;
            this.password = password;
        }
        public boolean validate(){
            if(this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)){
                return true;
            }
            return false;
        }
        public String toString(){
            return "<< Account >>" + "\nName : " + name +
                    "\nEmail : " + email +
                    "\nPassword : " + password;
        }
        public Object write(){
            return null;
        }
        public boolean read(String content){
            return false;
        }
    }
}