package practice2_package;

/*
 * void addFirst(item x)
 * void addLast(item x)
 * item getFirst()
 * item getLast()
 * item removeLast()
 * item get(int x)
 * void insert(item x, int pos)
 * int size()*/

public class SLList <T> implements List61B<T> {

    /*Generic type T used everywhere instead of int, sentinel item declared as null, type must be declared upon
     * declaration, instantiation, and assignment*/

    /*Eliminating naked objects*/
    /*could be static (it NEVER LOOKS OUTWARD)*/
    private class Node{ //nested class
        public T item;
        public Node next;
        /*Useful to be nested if completely made for SLList Class*/
        public Node(T i, Node n){
            item = i;
            next = n;
        }
    }

    /*Private so one can't mess with object*/
    private Node sentinel; //less for user to understand
    private int size;
    /*SLList constructor*/
    /*Sentinel nodes eliminate need for special case addLast w/ empty SLList*/
    public SLList(T x){
        sentinel = new Node(null,null); //999 default arb value
        sentinel.next = new Node(x,null);
        size = 1;
    }

    public SLList(){
        sentinel = new Node(null,null);
        size = 0;
    }

    @Override
    public void addFirst(T x){
        sentinel.next = new Node(x,sentinel.next);
        size += 1;
    }

    @Override
    public void addLast(T x){
        Node tmp = sentinel;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new Node(x,null);
        size += 1;
    }

    @Override
    public T getFirst(){
        return sentinel.next.item;
    }

    @Override
    public T getLast(){
        return get(size-1);
    }

    @Override
    public T removeLast(){
        Node curr = sentinel.next;
        Node prev = sentinel;
        while (curr.next != null){
            curr = curr.next;
            prev = prev.next;
        }
        prev.next=null;
        return curr.item;
    }

    @Override
    public T get(int x){
        if (x == 0){
            return sentinel.next.item;
        }
        Node tmp = sentinel.next;
        while (x != 0){
            tmp = tmp.next;
            x--;
        }
        return tmp.item;
    }

    @Override
    public void insert(T x, int idx){
        if (idx == 0){
            this.addFirst(x);
        } else if (idx >= size) {
            this.addLast(x);
        } else {
            Node tmp = sentinel.next;
            while (idx != 1){
                tmp = tmp.next;
                idx--;
            }
            tmp.next = new Node(x,tmp.next);
            size+=1;
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void print(){
        for (Node tmp = sentinel.next; tmp != null; tmp = tmp.next){
            System.out.print(tmp.item + " ");
        }
        System.out.println();
    }


    public void reverse(){
        /*edge case, if list is empty or 1 element, could use size attribute*/
        if (sentinel.next == null || sentinel.next.next == null){
            return;
        }
        Node curr = sentinel.next.next; //current working node
        sentinel.next.next = null; //first node will be the new last node
        Node tmp; //pointer to hold nodes after current during loop
        while (curr != null){
            tmp = curr.next;
            curr.next = sentinel.next;
            sentinel.next = curr;
            curr = tmp;
        }
    }

    /*heakper function for recursive method*/
    public void reverseRe(){
        this.sentinel.next = reverseRec(sentinel.next);
    }

    /*Goes to the tail of the list, makes it the new head, then passes it forward while making each node N at a given
     * stage of the recursion the new tail of the reversing list. WATCH HOW IT WORKS IN THE JAVA VISUALIZER!!!*/
    private Node reverseRec(Node N){
        if (N == null || N.next == null){
            return N;
        } else {
            Node tmp = N.next; //N.next will change before the recursion returns to a given step, so we must save it
            Node head = reverseRec(N.next); //passing the rest of the list into the function, will return the new head
            tmp.next = N; //move N to the back of the line
            N.next = null; //make the last node point nowhere
            return head; //pass the head up the line
        }
    }


    public static void main(String args[]){
        SLList<Integer> L = new <Integer>SLList();
        int i = 0;
        while (i != 5){
            L.addLast(i);
            i++;
        }
//        while (i != 10){
//            L.addFirst(i);
//            i++;
//        }
//        L.insert(666,5);
//        L.insert(111,0);
//        L.insert(101010,L.size);
//        L.reverse();
        L.reverseRe();
        System.out.println(L.get(3));
        System.out.println(L.size());
        L.removeLast();
        L.print();

    }

}
