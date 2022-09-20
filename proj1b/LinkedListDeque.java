public class LinkedListDeque<Item> implements Deque<Item>{
    //https://www.cs.dartmouth.edu/~scot/cs10/lectures/6/6.html

    /**attributes*/
    private node sentinel;
    private int size;

    /*nested node class*/
    public class node{
        public Item item;
        public node prev;
        public node next;

        public node(Item i, node p, node n){
            item = i;
            prev = p;
            next = n;
        }

    }

    /*constructor for empty*/
    public LinkedListDeque(){
        sentinel = new node(null, null, null);
        size = 0;
    }

    /*constructor*/
    public LinkedListDeque(Item x){
        sentinel = new node(null, null, null);
        sentinel.next = new node(x,sentinel,sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public LinkedListDeque(LinkedListDeque other){
        int step = 0;
        sentinel = new node(null, null, null);
        while (step < other.size){
            Item idx = (Item)other.get(step);
            addLast(idx);
            /*Below is the same as calling addLast, addLast always faster than first*/
//            if (sentinel.next == null){
//                sentinel.next = new node(idx,sentinel,sentinel);
//                sentinel.prev = sentinel.next;
//            } else {
//                sentinel.prev.next = new node(idx,sentinel.prev,sentinel);
//                sentinel.prev = sentinel.prev.next;
//            }
//            size += 1;
            step += 1;
        }
    }

    /*************************************** Add Methods *************************************/
    @Override
    public void addFirst(Item x){
        if (sentinel.next == null){
            sentinel.next = new node(x,sentinel,sentinel);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next.prev = new node(x,sentinel,sentinel.next);
            sentinel.next = sentinel.next.prev;
        }
        size += 1;
    }

    @Override
    public void addLast(Item x){
        if (sentinel.next == null){
            sentinel.next = new node(x,sentinel,sentinel);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.prev.next = new node(x,sentinel.prev,sentinel);
            sentinel.prev = sentinel.prev.next;
        }
        size += 1;
    }

    /*************************************** Remove Methods *************************************/
    @Override
    public Item removeFirst(){
        if (this.sentinel.next == null){
            return null;
        } else {
            node first = this.sentinel.next;
            if (this.size == 1){
                sentinel.next = null;
                sentinel.prev = null;
            } else {
                sentinel.next = sentinel.next.next;
                sentinel.next.prev = sentinel;
            }
            first.next = null;
            first.prev = null;
            size -= 1;
            return first.item;
        }
    }

    @Override
    public Item removeLast(){
        if (this.sentinel.prev == null){
            return null;
        } else {
            node last = this.sentinel.prev;
            if (this.size == 1){
                sentinel.next = null;
                sentinel.prev = null;
            } else {
                sentinel.prev = sentinel.prev.prev;
                sentinel.prev.next = sentinel;
            }
            last.next = null;
            last.prev = null;
            size -= 1;
            return last.item;
        }
    }

    @Override
    public Item get(int index){
        node curr = this.sentinel.next;
        int step = 0;
        while(step != index){
            curr = curr.next;
            step += 1;
        }
        return curr.item;
    }


    /**Inherits isEmpty from implementation Deque*/
    @Override
    public int size() {
        return size;
    }

    @Override
    public void print(){
        if (this.size == 0){
            return;
        }
        node curr = this.sentinel.next;
        String S = "";
        int count = 0;
        while (count < this.size){
            S += curr.item + " ";
            curr = curr.next;
            count += 1;
        }
        S += "\n";
        System.out.println(S);
    }

    public Item getRecursive(int index){
        node walker = new node(sentinel.item, sentinel.prev, sentinel.next);
        return getReHelp(walker.next, index);
    }

    private Item getReHelp(node DLL, int idx){
        if (idx == 0){
            return DLL.item;
        } else {
            return getReHelp(DLL.next, idx - 1);
        }
    }

    /** My testing grounds **/
    public static void main(String args[]){
        LinkedListDeque<Integer> L = new LinkedListDeque<>(5);
        L.addFirst(10);
        L.addFirst(15);
        L.addFirst(20);
        L.addLast(1);
        L.addLast(0);
        System.out.println(L.get(1));
        L.print();
        L.removeFirst();
        L.removeLast();
        L.print();
        System.out.println(L.getRecursive(3));
        L.print();
        LinkedListDeque F = new LinkedListDeque(L);
        F.print();

    }

}
