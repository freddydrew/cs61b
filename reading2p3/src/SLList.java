public class SLList<LochNess> {
    /**The user doesn't need to know the implementation details,
     * and it's safe to change private methods*/
    private StuffNode sentinel; //can't use this outside the SLList Class
    private int size; //caching the size baby
    /* Caching just means setting stuff aside as you go so it can be used later */

    /**Nested Class, because StuffNode is just a part of SLList at heart .
     * A basic rule of thumb: If they don't need it, make it private.*/
    public class StuffNode { //Called a subordinate class
        public LochNess item; //when the class is private, the access modifiers in it no longer matter
        public StuffNode next;

        public StuffNode(LochNess i, StuffNode n){
            item = i;
            next = n;
        }
    }

    /**Public things have the expectation that they will always be there
     * (it stays true forever) */
    public SLList(LochNess x){
        sentinel = new StuffNode(x, null);
        size = 1;
    }

    public SLList(){
        size = 0;
        sentinel = new StuffNode(null,null);
    }

    public void addFirst(LochNess x){
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    public void addLast(LochNess x){
        StuffNode node = sentinel; //we use another pointer to climb down to the bottom and add to the list
        while (node.next != null) {
            node = node.next;
        }
        node.next = new StuffNode(x, null);
        size += 1;
    }

    //* Works with an initialized list only, interesting */
    public int sizeIt(){
        int count = 0; //for first element
        StuffNode node = sentinel.next;
        while (node != null){
            count += 1;
            node = node.next;
        }
        return count;
    }

    public int sizeRe(StuffNode node){
        if (node.next == null){
            return 1;
        } else {
            return 1 + sizeRe(node.next);
        }
    }

    public int sizeRe(){
        StuffNode node = sentinel.next;
        return sizeRe(node);
    }

    public LochNess getFirst(){
        return sentinel.next.item;
    }

    public void printNodes(){
        StuffNode node = sentinel.next;
        while (node != null){
            System.out.println(node.item);
            node = node.next;
        }
    }


    public static void main(String[] args){
        SLList<Integer> LL = new SLList<Integer>();
        LL.addLast(20);
        LL.addFirst(10);
        LL.addFirst(5);
        System.out.println("Iterative size of LL: " + LL.sizeIt());
        LL.printNodes();
        System.out.println("Recursive size of LL: " + LL.sizeRe());
        System.out.println("Private variable size of LL: " + LL.size);

    }
}
