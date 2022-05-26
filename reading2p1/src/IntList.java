public class IntList {
    public int first;
    public IntList rest;

    //constructor for a linked list
    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    //size with recursion
    public int size(){
        if (this.rest == null){
            return 1;
        } else {
            return this.rest.size() + 1;
        }
    }

    //size with iteration
    public int iterativeSize(){
        int count = 0;
        IntList L = this;
        while (L != null){
            count += 1;
            L = L.rest;
        }
        return count;
    }

    //get an item with recursion
    public int get(int item){
        if (item == 0){
            return this.first;
        } else {
            return this.rest.get(item-1);
        }
    }

    //increment the elements of a list without destroying it
    public static IntList incrList(IntList L, int x){
        if (L.rest == null){
            return new IntList(L.first + x,null);
        } else {
            return new IntList(L.first + x,incrList(L.rest,x));
        }
    }

    //increment the elements of a list without destroying it
    public static IntList dincrList(IntList L, int x){
        if (L.rest == null){
            L.first += x;
            return L;
        } else {
            L.first += x;
            L.rest = dincrList(L.rest,x);
            return L;
        }
    }

    //build it backwards with 5 at the front
    public static void main(String[] args){
        IntList L = new IntList(15,null);
        L = new IntList(10,L);
        L = new IntList(5,L);

        //testing out the methods
        System.out.println("Size of L with recursion: " + L.size());
        System.out.println("Size of L with iteration: " + L.iterativeSize());
        System.out.println("2nd Element of L with recursion: " + L.get(2));

        //Copy elements of L into a new list and increment the elements by X
        IntList Q = incrList(L,3);

        System.out.println("Size of Q with recursion: " + Q.size());
        System.out.println("Size of Q with iteration: " + Q.iterativeSize());
        System.out.println("1st Element of Q with recursion: " + Q.get(0));
        System.out.println("2nd Element of Q with recursion: " + Q.get(1));
        System.out.println("3rd Element of Q with recursion: " + Q.get(2));

        //making sure the destructive copy and increment function worked
        IntList F = dincrList(L,3);
        System.out.println(F.get(0));
        System.out.println(L.get(0));
        System.out.println(F.get(1));
        System.out.println(L.get(1));
        System.out.println(F.get(2));
        System.out.println(L.get(2));
        System.out.println(F.size());

    }
}
