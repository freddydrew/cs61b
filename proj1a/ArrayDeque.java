
public class ArrayDeque<T> {
    private int size;
    private T[] items;

    public ArrayDeque(){
        size = 0;
        items = (T[]) new Object[8];
    }

    public ArrayDeque(ArrayDeque other){
        size = other.size();
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items,0,items,0,size);
    }

    public void addFirst(T x){
        if (size != (items.length)) {
            System.arraycopy(items,0,items,1,size);
        } else {
            resize(2*size,1);
        }
        items[0] = x;
        size += 1;
    }

    public void addLast(T x){
        if (size == items.length){
            resize(2*size,0);
        }
        items[size] = x;
        size += 1;
    }

    public void resize(int capacity, int destPos){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,destPos,size);
        items = a;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i ++){
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst(){
        T first = items[0];
        items[0] = null;
        size -= 1;
        if (((double) size/items.length) < .25){
            resize(2*size,0);
        };
        return first;
    }

    public T removeLast(){
        T last = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        if (((double) size/items.length) < .25){
            resize(2*size,0);
        };
        return last;
    }

    public T get(int index){
        return items[index];
    }

    public static void main(String args[]){
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for (int j = 0; j < 8; j++){
            A.addFirst(j);
        }
        A.printDeque();
        System.out.println("Size = " + A.size());
        for (int j = 0; j < 8; j++){
            A.addLast(j);
        }
        A.printDeque();
        System.out.println("Size = " + A.size());
        for (int j = 0; j < 14; j++){
            A.removeLast();
        }
        A.printDeque();
        System.out.println("Size = " + A.size());
        ArrayDeque B = new ArrayDeque(A);
    }
}
