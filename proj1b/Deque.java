public interface Deque<T>{
    /** the order of the methods is the same across classes that implement Deque*/
    /*add operations*/
    public void addFirst(T item);
    public void addLast(T item);

    /*remove operations*/
    public T removeFirst();
    public T removeLast();

    /*get, size, print*/
    public T get(int idx);
    public int size();
    public void print();

    /*all subclasses inherit*/
    default public boolean isEmpty(){
        if (size() != 0){
            return false;
        }
        return true;
    };
}
