package practice2_package;

public class playground {

    public static void main(String args[]){
        List61B<Integer> someList = new AList<Integer>();
        int i = 0;
        while (i < 10){
            someList.addLast(i);
            i++;
        }
        someList.print();

        VengefulSLList<Integer> L = new VengefulSLList<Integer>();
        L.printLostItems();

    }

}
