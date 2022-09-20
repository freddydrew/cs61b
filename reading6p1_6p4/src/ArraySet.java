import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**Sets can only contain one of each thing, no duplicate values in a set*/
public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private int size;

    public ArraySet(){
        items = (T[]) new Object[100];
        size = 0;
    }

    /**Checks if item is in set by iterating through the set*/
    /*Must use .equals to see if item semantically equals thew ith part of the set.
    * Using == instead checks if the memory box addresses are equal*/
    public boolean contains(T item){
        for (int i = 0; i < size; i++){
            if (items[i] == null){
                if (item == null){
                    return true;
                }
            } else if (items[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    /**If the item doesn't exist in the set, it adds it.*/
    public void add(T item){
        if (item == null) {
            return;
        }
        if (contains(item)){
            return;
        }
        items[size] = item;
        size += 1;
    }

    /**Returns the size of the set*/
    public int getSize(){
        return  size;
    }

    @Override
    public String toString(){
        StringBuilder returnSB = new StringBuilder("{");//linear time, old way was quadratic
        for (int i = 0; i < size -1; i++){ //implicitly calls toString when adding a random type to a string
            returnSB.append(items[i]);
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }

    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    @Override
    public boolean equals (Object other){ //need to completely rip off the superclass function call
        if (other == null){
            return false;
        }
        if (other.getClass() != this.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other; //need to cast it to our type
        if (o.getSize() != this.size){
            return false;
        }
        for (T item: this){
            if (!o.contains(item)){
                return false;
            }
        }
        return true;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int WizPos;
        public ArraySetIterator(){
            WizPos = 0;
        }

        public boolean hasNext() {
            return WizPos < size;
        }

        public T next() {
            T returnItem = items[WizPos];
            WizPos += 1;
            return returnItem;
        }
    }

    public static void main(String[] args){
        ArraySet<String> s = new ArraySet<>();
        /*if null is added to this array, we'll get a null pointer exception if we try to add other things after it
        * unless we add an exception. Why? -> because items in the ArraySet are addresses to string reference objects
        * so trying to check if the items is in there renders a null pointer exception ar the .equals method in the
        * contains method*/
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");

        Set<String> s2 = new HashSet<>();
        s2.add(null);
        System.out.println(s2.contains(null));

        Set<Integer> s3 = new HashSet<>();
        s3.add(5);
        s3.add(23);
        s3.add(42);
        Iterator<Integer> seer = s3.iterator();
        while (seer.hasNext()){
            int i = seer.next();
            System.out.println(i);
        }
        Iterator<String> myseer = s.iterator();
        while (myseer.hasNext()){
            String str = myseer.next();
            System.out.println(str);
        }

        for (String str : s){
            System.out.println(str);
        }

        System.out.println(s);
        System.out.println(s.equals(s3));

    }
}
