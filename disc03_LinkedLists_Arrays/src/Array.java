public class Array {

    public static int[] insert(int[] arr, int item, int position){
        int[] x = new int[arr.length + 1];
        int j = 0;
        while (j < position){
            x[j] = arr[j];
            j+=1;
        }
        x[position] = item;
        j = position+1;
        while (j < arr.length){
            x[j] = arr[j];
            j+=1;
        }
        return x;
    }

    public static void reverse(int[] arr){
        int i = 0;
        while(i < (arr.length)/2 ){
            int j = arr.length - 1 - i;
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
            i ++;
        }
    }

    //assumes a sorted list of integers like 3,2,1 or 1,2,3,4,5
    public static int[] replicate(int[] arr){
        int i = 0;
        int sum = 0;
        while (i < arr.length){
            sum += arr[i];
            i++;
        }

        int [] y = new int[sum*2];
        int idx = 0;
        for (int element : arr){
            if (element == 0){
                idx ++;
                continue;
            }
            for (int j = 0; j < element; j ++){
                y[idx] = element;
                idx ++;
            }
        }
        return y;
    }

    public  static void main(String args[]){
        int[] x = new int[12];
        int i = 0;
        while (i < 6){
            x[i] = i;
            i ++;
        }

        reverse(x);
        int[] f = replicate(x);
    }
}
