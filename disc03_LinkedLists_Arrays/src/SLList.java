public class SLList {
    private IntNode first;

    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i,IntNode n){
            this.item = i;
            this.next = n;
        }
    }

    public void addFirst(int x){
        first = new IntNode(x,first);
    }

    public void insert(int item, int position){
        IntNode N = first;
        int idx = 0;
        while (idx < position - 1){
            if (N.next == null){
                N.next = new IntNode(item,null);
                return;
            } else {
                N = N.next;
                idx += 1;
            }
        }
        N.next = new IntNode(item,N.next);
    }

    public void reverse(){
        if (first == null || first.next == null){
            return;
        }
        IntNode target = first.next; //grabbing the head of the list, this will change each loop
        first.next = null; //new end of the list points nowhere

        while (target != null){
            IntNode tmp = target.next; //so we don't lose the rest of the list
            target.next = first; //point the targets next to the current first node of the list
            first = target; //point the head of the list toward the new first node
            target = tmp; //sets up the rest of the list to be the new target
        }
    }

    public void reverseRecursive(){
        reverseHelp(first);
    }

    private IntNode reverseHelp(IntNode n){
        if (n == null || n.next == null){
            return n;
        } else {
            IntNode AfterTarget = n.next;
            IntNode Target = reverseHelp(n.next);
            AfterTarget.next = n;
            n.next = null;
            return Target;

        }
    }


    public static void main(String args[]){
        SLList L = new SLList();
        for (int i = 0; i < 5; i ++){
            L.addFirst(i);
        }

//        L.insert(5,5);
//        L.insert(99,3);
        L.reverse();
        L.reverseRecursive();
    }
}
