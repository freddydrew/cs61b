public class FunctionDemo {
    public static int larger(int x,int y){
        /** Return the larger of the two integers */
        if (x > y){
            return x;
        }
        return y;
    }

    public static void main(String[] args){
        System.out.println(larger(5,6));
    }
}
