public class ArrayPractice {

    /*2.3 question*/
    public static int[] replicate(int[] x){
        int new_len = 0;
        for (int item : x){
            new_len += item; //gives me the length of the array to be returned
        }
        int[] r = new int[new_len];
        int idx = 0;
        for (int i = 0; i < x.length; i++){
            int count = x[i];
            for (int j = 0; j < count; j++){
                r[idx] = x[i];
                idx++;
            }
        }
        return r;
    }

    /*exam prep 2 question 1*/
   public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int[] i : x) {
            totalLength += i.length;
            }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int m = 0; m < x.length; m++) {
            for (int n = 0; n < x[m].length; n++){
                a[aIndex] = x[m][n];
                aIndex ++;
            }
        }
        return a;
        }

    public static void main(String args[]){
        int[] y = new int[]{4,5,6}; //y is a pointer to an int object, a reference
        int[] x = {1,2,3};
        int[][] flat = new int[][]{{1, 2, 3}, {}, {7, 8}};
        System.arraycopy(x,0,y,1,1); //from X at idx 0, to Y at idx 1, copy just one element
        int len = x.length;

        String[] s = new String[6];
        s[0] = "fred";
        s[x[2]] = "drew";

        /*2-D Arrays YAY!*/
        /*the first [] indicates the size of the array of REFERENCES to the other arrays in the array!*/
        int[][] m;
        m = new int[4][2];
        int i = 0;
        int j = 0;
        while (i < m.length){
            m[i][j] = i;
            i++;
            if (i == m.length){
                j++;
                i = 0;
            }
            if (j==2){
                break;
            }
        }

        int[] f = new int[]{3,2,1,1,2,3};
        int[] r = replicate(f);
        int[] flattened = flatten(flat);
        System.out.println("end");

    }
}
