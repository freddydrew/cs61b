public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    //Reversal with iteration
    public static IntList reverse(IntList L){
        IntList prev, curr, next;
            curr = L; //pointer for walking through L
            prev = null; //creating pointer to track previous node, starts at null for start of list
            while(curr != null){
                next = curr.rest; //saving the next node
                curr.rest = prev; //pointing the current nodes rest to the one before
                prev = curr; //setting the next iterations previous node to the current
                curr = next; //setting the next iterations current node to the next
            }
            return prev; //when i get to the end of the flipping, the last previous is the new head node
        }

    //Reversal with recursion
    public static IntList reverseRe(IntList L){
        if (L == null || L.rest == null) {
            return L;
        } else{
            IntList next = L.rest; //keeping the next node
            /** The following line will continue to pass the pointer to original lists last node while
             * building the new order behind it through operating on the next pointer */
            IntList newPrev = reverseRe(L.rest);
            L.rest = null; //cutting the link to the next node
            next.rest = L; //setting the next nodes rest pointer to the current node, flipping it
            return newPrev; //passing the new head of the reversed list up the chain
        }
    }

    public void insert(int x, int idx){
        IntList tmp = this;
        int curr_pos = 0;
        while (curr_pos != idx-1){
            tmp = tmp.rest;
            curr_pos ++;
        }
        tmp.rest = new IntList(x,tmp.rest);
        }

    public void remove(int idx){
        IntList tmp = this;
        IntList prev = null;
        while(idx != 0){
            prev = tmp;
            tmp = tmp.rest;
            idx --;
        }
        prev.rest = tmp.rest;
        tmp.rest = null;
    }

    public static void main(String args[]){
        IntList L = new IntList(5,null);
        int i = 4;
        while(i>0){
            L = new IntList(i,L);
            i--;
        }

        L = reverse(L);
        L = reverseRe(L);
        L.insert(3,3);
        L.remove(3);


    }
}
