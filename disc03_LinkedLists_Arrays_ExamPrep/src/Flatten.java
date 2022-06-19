public class Flatten {

    public static int[] flatten(int[][] x){
        int totalLength = 0;
        for (int i = 0; i < x.length;i++){
            for (int j = 0; j < x[i].length; j++){
                totalLength ++;
            }
        }
        int[] v = new int[totalLength];
        int idx = 0;
        for (int i = 0; i < x.length;i++){
            for (int j = 0; j < x[i].length; j++){
                v[idx] = x[i][j];
                idx ++;
            }
        }

        return v;
    }
    public static void main(String args[]){
        int[][] a = new int[][]{{1, 2, 3}, {}, {7, 8}}; //2d array baby
        int[] X = flatten(a);
    }
}
