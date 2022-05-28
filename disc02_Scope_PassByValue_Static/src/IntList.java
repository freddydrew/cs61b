public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r){
        this.first = f;
        this.rest = r;
    }

    public static IntList square(IntList L){

        IntList Q = new IntList(L.first, L.rest);
        if (Q.rest == null){
            Q.first = Q.first*Q.first;
            return Q;
        } else {
            Q.first = Q.first*Q.first;
            return new IntList(Q.first, square(Q.rest));
        }
    }

    public static IntList squareIterative(IntList L){
        IntList Q = new IntList(L.first, L.rest);
        while (Q.rest != null){
            Q.first = Q.first*Q.first;
            return new IntList(Q.first, square(Q.rest));
        }
        Q.first = Q.first*Q.first;
        return Q;
    }

    public static IntList squareDestructive(IntList Q){
        if (Q.rest == null){
            Q.first = Q.first*Q.first;
            return Q;
        } else {
            Q.first = Q.first*Q.first;
            squareDestructive(Q.rest);
            return Q;
        }

    }

    public static IntList squareDestructiveIt(IntList Q){
        while (Q.rest != null){
            Q.first = Q.first*Q.first;
            return squareDestructive(Q.rest);
        }
            Q.first = Q.first*Q.first;
            return Q;
    }
    public static void main(String[] args) {
        IntList L = new IntList(4, null);
        L = new IntList(3, L);
        L = new IntList(2, L);
        L = new IntList(1, L);
        IntList F = square(L);
        IntList Q = squareDestructive(F);
        IntList Q1 = squareDestructive(F);
    }
}
