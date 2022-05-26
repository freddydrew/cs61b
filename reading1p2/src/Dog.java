public class Dog {
    //Properties/ instance variables
    public int weightInPounds;
    public static String binomen = "Canis familiaris";

    //constructor
    public Dog(int w){
        weightInPounds = w;
    }

    //instance method, a.k.a. a Non-Static method
    //if the method has to use specific to an instance variables, it's non-static
    public void makeNoise(){
        if (weightInPounds < 10){
            System.out.println("Yip!");
        } else if (weightInPounds < 30){
            System.out.println("Bark!");
        } else {
            System.out.println("Bark!");
        }
    }

    //static class method that returns the larger dog
    public static Dog maxDog(Dog d1, Dog d2){
        if (d1.weightInPounds > d2.weightInPounds){
            return d1;
        }
        return d2;
    }
}
