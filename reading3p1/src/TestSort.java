import org.junit.Test;
import  static org.junit.Assert.*;

/*Tests the Sort class*/
public class TestSort {

    @Test
    public void testSort(){
        String [] input = {"i", "have", "an", "egg"};
        String [] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        //objects are only equal in java if they are pointing at the same place
        //if (input != expected){ SO THIS DOESN'T WORK!!!

        /*We could also iterate through the array to see where the real difference is!*/
//        if (!java.util.Arrays.equals(input,expected)){
//            System.out.println("Error! there seems to be a problem with Sort.sort()!");
//        }

//        for (int i = 0; i < input.length; i++){
//            if (!input[i].equals(expected[i])){
//                System.out.println("Mismatch index: expected '" + expected[i] + "' but got '" + input[i] + "'");
//                return;
//            } else {
//                System.out.println("They match!");
//            }
//        }

        /*Could also use this one liner to do the same thing!*/
        //org.junit.Assert.assertEquals(expected,input); // this is deprecated (not recommended anymore)
        assertArrayEquals(expected,input);

    }
    @Test
    public void testFindSmallest(){
        String [] input = {"i", "have", "an", "egg"};
        String [] expected = {"an", "egg", "i", "have"};

        int s = Sort.findSmallest(input,0);
        assertEquals(expected[0],input[s]);

        String [] input2 = {"there", "are", "many", "pigs"};
        String [] expected2 = {"there", "are", "many", "pigs"};

        int s2 = Sort.findSmallest(input2,0);
        assertEquals(expected2[1],input2[s2]);
    }

    @Test
    public void testSwap(){
        String [] input = {"i", "have", "an", "egg"};
        String [] expected = {"egg", "have", "an", "i"};

        Sort.swap(input,0,3);
        assertArrayEquals(expected,input);
    }

    public static void main(String args[]){
//        testFindSmallest();
//        testSwap();
//        testSort();

    }
}
