import java.util.Comparator;

public class Maximizer {
    public static Comparable max(Comparable[] items){
        int maxDex = 0;
        for (int i = 0;i < items.length; i++){
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0){
                maxDex = i;
            }
        }
        return items[maxDex];
    }


    public static void main(String[] args){
        Dog[] dogs = {new Dog("Elyse",3),new Dog("Sture", 9), new Dog("Artemesios",15)};
        Dog maxDog = (Dog)  max(dogs);
        maxDog.bark();
        Dog d1 = new Dog("Elyse",3);
        Dog d3 = new Dog("Artemesios",15);

        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(d1,d3)>0){
            d1.bark();
        } else {
            d3.bark();
        }
    }
}
