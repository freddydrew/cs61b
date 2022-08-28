public class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
        this.noise = "Meow!";

    }

    @Override
    public void greet(){
        System.out.println("Cat " + name + " says: " + makeNoise());
    }


    public static void main(String args[]){
        Cat fred = new Cat("fred",28);
        fred.greet();
        /*assignment of one object of static type, say animal, to another object with a static type of dog,
        * will crash at compile. Use type casting to make sure the object of parent class is cast to the same type
        * of that of the subclass.*/
    }
}
