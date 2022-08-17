public class DLList <T>{
    public node sentinel;
    public int size;

    private class node{
        private node prev;
        private T item;
        private node next;

        public node(node p, T i, node n){
            prev = p;
            item = i;
            next = n;
        }
    }

    public DLList(){
        sentinel = new node(null,null,null);
        size = 0;
    }

    public DLList(T i){
        sentinel = new node(null,null,null);
        sentinel.next = new node(sentinel,i,sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T i){
        if (sentinel.next == null){
            sentinel.next = new node(sentinel,i,sentinel);
            sentinel.prev = sentinel.next;
            size = 1;
            return;
        }
        node oldHead = sentinel.next;
        sentinel.next = new node(sentinel,i,oldHead);
        oldHead.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T i){
        if (sentinel.next == null){
            sentinel.next = new node(sentinel,i,sentinel);
            sentinel.prev = sentinel.next;
            size = 1;
            return;
        }
        node oldLast = sentinel.prev;
        sentinel.prev = new node(oldLast,i,sentinel);
        oldLast.next = sentinel.prev;
        size += 1;
    }

    public void reverse(){
        node tmp = sentinel.next;
        node newPrev = null;
        node next = null;
        int count = 0;
        while (count <= size){
            next = tmp.next;
            tmp.next = tmp.prev;
            tmp.prev = next;
            tmp = tmp.next;
            count ++;
        }
    }

    public void reverseRe(){
        reverseReHelp(sentinel.next);
        node tmp = sentinel.prev;
        sentinel.prev = sentinel.next;
        sentinel.next = tmp;
        sentinel.next.prev = sentinel;
        sentinel.prev.next = sentinel;
    }

    private node reverseReHelp(node n){
        if (n.next == sentinel){
            return n;
        } else {
            node following = n.next;
            node newPrev = reverseReHelp(n.next);
            following.next = n;
            n.prev = following;
            return newPrev;
        }
    }

    public static void main(String args[]){
        DLList<Integer> L = new DLList<>();
        int i = 0;
        while (i < 10) {
            L.addLast(i);
            i ++;
        }
        L.addLast(10);
        L.reverse();
        L.reverseRe();
    }
}
