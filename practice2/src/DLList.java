public class DLList {

    /*nested node class*/
    private class node{
        /*prev pointer, int item, next pointer*/
        public node prev;
        public int item;
        public node next;
        public node(node p, int i, node n){
             prev = p;
             item = i;
             next = n;
        }
    }
    /*head of list, size of list*/
    private node sentinel;
    private int size;
    /*DLList constructor empty list*/
    public DLList(){
        sentinel = new node(null,999,null);
        size = 0;
    }
    /*DLList constructor*/
    public DLList(int x){
        sentinel = new node(null,999,null);
        sentinel.next = new node(sentinel,x,sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /*addFirst*/
    public void addFirst(int x){
        node tmp = sentinel.next;
        sentinel.next = new node(sentinel,x,tmp);
        tmp.prev = sentinel.next;
    }

    public void addLast(int x){
        node tmp = sentinel.prev;
        sentinel.prev = new node(tmp,x,sentinel);
        tmp.next = sentinel.prev;
    }

    public static void main(String args[]){
        DLList L = new DLList(5);
        int i = 4;
        while (i > 0) {
            L.addFirst(i);
            i--;
        }
        i = 6;
        while (i < 11) {
            L.addLast(i);
            i++;
        }
        System.out.println("End");
    }
}
