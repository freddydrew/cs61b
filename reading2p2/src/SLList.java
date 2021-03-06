public class SLList {
    /**The user doesn't need to know the implementation details,
     * and it's safe to change private methods*/
    private IntNode sentinel; //can't use this outside the SLList Class
    private int size; //caching the size baby
    /* Caching just means setting stuff aside as you go so it can be used later */

    /**Nested Class, because IntNode is just a part of SLList at heart .
     * A basic rule of thumb: If they don't need it, make it private.*/
    private static class IntNode { //Called a subordinate class
        public int item; //when the class is private, the access modifiers in it no longer matter
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    /**Public things have the expectation that they will always be there
     * (it stays true forever) */
    public SLList(int x){
        sentinel = new IntNode(999,null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(){
        size = 0;
        sentinel = new IntNode(999,null);
    }

    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public void addLast(int x){
            IntNode node = sentinel; //we use another pointer to climb down to the bottom and add to the list
            while (node.next != null) {
                node = node.next;
            }
            node.next = new IntNode(x, null);
            size += 1;
        }

    //* Works with an initialized list only, interesting */
    public int sizeIt(){
        int count = 0; //for first element
        IntNode node = sentinel.next;
        while (node != null){
            count += 1;
            node = node.next;
        }
        return count;
    }

    private static int sizeRe(IntNode node){
        if (node.next == null){
            return 1;
        } else {
            return 1 + sizeRe(node.next);
        }
    }

    public int sizeRe(){
        IntNode node = sentinel.next;
        return sizeRe(node);
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void printNodes(){
        IntNode node = sentinel.next;
        while (node != null){
            System.out.println(node.item);
            node = node.next;
        }
    }


    public static void main(String[] args){
        SLList LL = new SLList();
        LL.addLast(20);
        LL.addFirst(10);
        LL.addFirst(5);
        System.out.println("Iterative size of LL: " + LL.sizeIt());
        LL.printNodes();
        System.out.println("Recursive size of LL: " + LL.sizeRe());
        System.out.println("Private variable size of LL: " + LL.size);

    }
}
