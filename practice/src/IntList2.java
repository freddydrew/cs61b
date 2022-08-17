public class IntList2 {
    /*I took a few month break so I need a refresher*/
    int first;
    IntList2 rest;

    /*Constructor*/
    public IntList2(int f, IntList2 r){
        first = f;
        rest = r;
    }

    /*Insert method*/
    public void insert(int n, int idx){
        IntList2 tmp = this;  //saving the pointer to the list to walk down list with
        int curr = 0; //we're walking down the list so we start at 0
        while (curr != idx - 1){
            tmp = tmp.rest;
            curr++;
        }
        tmp.rest = new IntList2(n,tmp.rest);
    }

    /*Remove Method*/
    public void remove(int idx){
        IntList2 tmp = this;
        if (idx == 0){

        }
    }

}
