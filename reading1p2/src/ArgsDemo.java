public class ArgsDemo {
    public static void main(String[] args){
        int i = 0;
        int n = args.length;
        int sum = 0;
        while (i < n){
            sum = sum + Integer.parseInt(args[i]);
            i = i + 1;
        }
        System.out.println(sum);
    }
}
