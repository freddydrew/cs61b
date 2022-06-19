public class SLList {
    public node first;

    private class node{
        private int item;
        private node rest;

        public node(int i, node n){
            item = i;
            rest = n;
        }
    }

    public SLList(int x){
        first = new node(x,null);
    }

    public void addFirst(int x){
        first = new node(x,first);
    }

    public void addLast(int x){
        node tmp = first.rest;
        while (tmp.rest != null){
            tmp = tmp.rest;
        }
        tmp.rest = new node(x,null);
    }

    public void reverse(){
        node curr = first;
        node prev = null;
        node next;
        while (curr != null){
            next = curr.rest;
            curr.rest = prev;
            prev = curr;
            curr = next;
        }
        first = prev;
    }

    public void reverseRe(){
        first = reverseReHelp(first);
    }

    private node reverseReHelp(node n){
        if (n == null || n.rest == null){
            return n;
        } else {
            node next = n.rest;
            node newPrev = reverseReHelp(n.rest); //allows the passage of the original last node
            next.rest = n; //change pointers in the next node
            n.rest = null; //cut the original connection
            return newPrev; //pass forward the new head node with its connections
        }
    }


    public static void main(String args[]){
        SLList L = new SLList(6);
        for (int i = 5;i > 0; i--){
            L.addFirst(i);

        }
        L.addLast(7);
        L.reverse();
        L.reverseRe();
    }
}
