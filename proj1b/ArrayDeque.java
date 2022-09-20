
public class ArrayDeque<Item> implements Deque<Item>{
    /**attributes*/
    private int size;
    private Item[] items;

    /*constructor for empty*/
    public ArrayDeque(){
        size = 0;
        items = (Item[]) new Object[32];
    }

    /*constructor*/
    public ArrayDeque(ArrayDeque other){
        size = other.size();
        items = (Item[]) new Object[other.items.length];
        System.arraycopy(other.items,0,items,0,size);
    }

    /*************************************** Add Methods *************************************/
    @Override
    public void addFirst(Item x){
        if (size != (items.length)) {
            System.arraycopy(items,0,items,1,size);
        } else {
            resize(2*size,1);
        }
        items[0] = x;
        size += 1;
    }

    @Override
    public void addLast(Item x){
        if (size == items.length){
            resize(2*size,0);
        }
        items[size] = x;
        size += 1;
    }

    /*************************************** Remove Methods *************************************/

    @Override
    public Item removeFirst(){
        Item first = items[0];
        Item[] a = (Item[]) new Object[items.length];
        System.arraycopy(items,1,a,0,size);
        items = a;
        size -= 1;
        if (((double) size/items.length) < .25){
            resize(2*size,0);
        };
        return first;
    }

    @Override
    public Item removeLast(){
        Item last = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        if (((double) size/items.length) < .25){
            resize(2*size,0);
        };
        return last;
    }

    @Override
    public Item get(int index){
        return items[index];
    }

    /**Inherits isEmpty from implementation Deque*/
    @Override
    public int size(){
        return size;
    }

    @Override
    public void print(){
        for (int i = 0; i < size; i ++){
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public void resize(int capacity, int destPos){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,destPos,size);
        items = a;
    }


    /** My testing grounds **/
    public static void main(String args[]){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for (int j = 0; j < 8; j++){
            A.addFirst(j);
        }
        A.print();
        System.out.println("Size = " + A.size());
        for (int j = 0; j < 8; j++){
            A.addLast(j);
        }
        A.print();
        System.out.println("Size = " + A.size());
        for (int j = 0; j < 14; j++){
            A.removeLast();
        }
        A.print();
        System.out.println("Size = " + A.size());
        ArrayDeque B = new ArrayDeque(A);
    }
}
