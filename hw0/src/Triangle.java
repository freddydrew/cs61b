public class Triangle {

    public static void drawTriangle(int n){
        String a = "*";
        for (int i = 0; i < n; i ++){
            System.out.print(a + "\n");
            a = a + "*";
        }
    }
    public static void main(String[] args){
        drawTriangle(10);
    }
}
