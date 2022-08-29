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

public class AList<Item> implements List61B<Item>{


    private int size;
    private Item[] items;

    /*Creates empty list*/
    public AList(){
        items = (Item[]) new Object[5];; //arbitrary allocation size at first
        size = 0; //list is empty

    }

    private void resize(int capacity){

        Item[] tmp = (Item[]) new Object[capacity]; //make a new list AList to point to with double the space
        System.arraycopy(items,0,tmp,0,size); //copy over the contents
        items = tmp; //point to new AList, old items gets destroyed
    }

    @Override
    /*addFirst*/
    public void addFirst(Item x){
        this.insert(x,0);
    }

    @Override
    public void addLast(Item x){
        if (size == items.length) {
            this.resize(size * 2);
        }
        items[size] = x;
        size+=1;
    }

    @Override
    public Item getFirst(){
        return items[0];
    }

    @Override
    public Item getLast(){
        return items[size-1];
    }

    @Override
    public Item removeLast(){
        Item x = getLast(); //gives me the thing to be removed
        items[size-1] = null; //avoid loitering
        size -= 1;
        return x; //returns the thing "removed"

    }

    @Override
    public Item get(int i){
        return items[i];
    }

    @Override
    public int size(){
        return size;

    }

    @Override
    public void insert(Item x, int idx){
        if (size == items.length && idx == size){
            this.addLast(x);
        } else if (size == items.length){
            this.resize(2*size);
        }
        Item[] tmp = (Item[]) new Object[items.length];
        System.arraycopy(items,0,tmp,0,idx);
        tmp[idx] = x;
        System.arraycopy(items,idx,tmp,idx+1,size-idx);
        size+=1;
        items = tmp;
    }

    /*flips the entire array around*/
    public void reverse(){
        for (int i = 0; i < items.length / 2; i++){
            Item tmp = items[i];
            items[i] = items[(size-1)-i];
            items[(size-1)-i] = tmp;
        }
    }

}
