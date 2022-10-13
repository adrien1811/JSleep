package AdrienArdraRamadhanJSleepMN;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

public class Algorithm {
    private Algorithm(){ }
    public static <T> int count(T[] itrarray, T val){
        final Iterator<T> counter = Arrays.stream(itrarray).iterator();
        return count(counter, val);
    }
    public static <T> int count(Iterator<T> itr, T val) {
        final Predicate<T> prd = val::equals;
        return count(itr, prd);
    }
    public static <T> int count(Iterator <T> iterator, Predicate pred){
        int count = 0;
        while (iterator.hasNext()){
            T i = iterator.next();
            if(pred.test(i)){
                count = count + 1;
            }
        }
        return  count;
    }
    public static <T> int count(Iterable<T> itr, Predicate<T> pred) {
        final Iterator<T> counter = itr.iterator();
        return count(counter, pred);
    }
    public static <T> int count(T[] itrarray, Predicate<T> pred) {
        final Iterator<T> counter = Arrays.stream(itrarray).iterator();
        return count(counter, pred);
    }
    public static <T> int count(Iterable<T> iterable, T val) {
        final Iterator<T> counter = iterable.iterator();
        return count(counter, val);
    }
    public static <T> boolean exists(T[] itrarray, T val) {
        final Iterator<T> counter = Arrays.stream(itrarray).iterator();
        return exists(counter, val);
    }

    public static <T> boolean exist(T[] itrarray, T val){
        final Iterator<T> counter = Arrays.stream(itrarray).iterator();
        return exists(counter,val);
    }
    public static <T> boolean exists(Iterator<T> iterator, T val){
        final Predicate<T> pred =val::equals;
        return exists(iterator,pred);
    }
    public static <T> boolean exists(Iterable<T> iterable, T val){
        final Iterator<T> counter = iterable.iterator();
        return exists(counter,val);
    }

    public static <T> boolean exists(T[] arr, Predicate<T> pred){
        final Iterator<T> count = Arrays.stream(arr).iterator();
        return exists(count,pred);
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> count = iterable.iterator();
        return exists(count,pred);
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()) {
            T i = iterator.next();
            //if(pred.pred(i))
                return true;
        }
        return false;
    }
    public static <T> T find(T[] array, T val){
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return find(counter,val);
    }
    public static <T> T find(Iterable<T> iterable, T val){
        final Iterator<T> counter = iterable.iterator();
        return find(counter,val);
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> count = iterable.iterator();
        return find(count,pred);
    }
    public static <T> T find(Iterator<T> iterator, T val){
        final Predicate<T> pred =val::equals;
        return find(iterator,pred);
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            T i = iterator.next();
            if (pred.test(i)) {
                return i;
            }
        }
        return null;
    }
    public static <T> List collect(Iterable<T> iterable,T val){
        final Iterator<T> collect = iterable.iterator();
        return collect((Iterable<T>)collect,val);
    }
    public static <T> List collect(Iterable<T> itr, Predicate<T> pred){
        final Iterator<T> collect = itr.iterator();
        return collect((Iterable<T>)collect,pred);
    }
    public static <T> List collect(T[]Arr, T val){
        final Iterator<T> collect = Arrays.stream(Arr).iterator();
        return collect((Iterable<T>)collect,val);
    }
    public static <T> List collect(Iterator<T> itr, T val){
        final Predicate<T> pred = val::equals;
        return collect((Iterator<T>) itr, (T) pred);
    }
    public static <T> List collect(T[]Arr, Predicate<T> pred){
        final Iterator<T> collect = Arrays.stream(Arr).iterator();
        return collect((Iterable<T>)collect,pred);
    }
    public static <T> List collect(Iterator<T> iterator, Predicate<T> pred)
    {
        final List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            final T var = iterator.next();
            if (pred.test(var)) {
                list.add(var);
            }
        }
        return list;
    }
    public static <T> List paginate(Iterator<T> iterator, int pages, int Size, Predicate<T> pred)
    {
        final List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            final T i = iterator.next();
            if (pred.test(i)) {
                list.add(i);
            }
        }
        return list;
    }
    public static <T> List paginate(Iterable<T> iterable, int pages, int Size, Predicate<T> pred)
    {
        final Iterator<T> itr = iterable.iterator();
        return paginate(itr, pages, Size, pred);
    }
    public static <T> List paginate(T[] arr, int pages, int Size, Predicate<T> pred)
    {
        final Iterator<T> paginate = Arrays.stream(arr).iterator();
        return paginate((Iterator<T>) paginate, pages, Size, pred);
    }
}
