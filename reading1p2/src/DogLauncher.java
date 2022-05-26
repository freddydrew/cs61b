public class DogLauncher {
    public static void main(String[] args){
        Dog d = new Dog(51); //[declaration] --> [assignment] --> [instantiation]
        d.makeNoise(); //invocation of a method

        Dog[] dogs = new Dog[2]; //declare a Dog array, assign it to instantiated array of dogs of size 2 called dogs
        dogs[0] = new Dog(8); //first element of dogs is a small Dog
        dogs[1] = new Dog(20); //second element of dogs is a medium Dog
        dogs[0].makeNoise(); //the little dog yips

        //showing off the static class variables
        System.out.println(Dog.binomen);
    }
}
