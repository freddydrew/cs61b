import java.util.Comparator;
public class Dog implements Comparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s){
        name = n;
        size = s;
    }

    public void bark(){
        System.out.println(name + " says: bark");
    }

    public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }
    /** Returns -1 if this dog is less than the dog pointed at by o.*/
    public int compareTo(Dog o){
        Dog uddaDog = o; //casting o to Dog so that the size attribute can be used
        if (this.size < uddaDog.size ){
            return -1;
        } else if (this.size == uddaDog.size){
            return 0;
        } else {
            return 1;
        }
    }

    private static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }
}
