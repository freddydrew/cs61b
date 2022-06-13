public class Sort {
    public static void sort(String[] input){
        //Find the smallest item
        //Move it to the front
        //Selection sort the rest
        sortStart(input,0);
    }

    private static void sortStart(String[] input,int startIdx){
        if (startIdx == input.length - 1){
            return;
        }
        int small = findSmallest(input,startIdx);
        swap(input, small, startIdx);
        sortStart(input,startIdx + 1);
    }

    public static void swap(String[] s, int a, int b){
        String tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }

    public static int findSmallest(String[] s,int start){
        int smallestIndex = start;
        for (int i = start; i < s.length; i++){
            //if first string lexicographically less than second string, returns -1
            int test = s[i].compareTo(s[smallestIndex]);
            if (test < 0){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
