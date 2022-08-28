public class AList <Item> {

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

    public void addLast(Item x){
        if (size == items.length) {
            this.resize(size * 2);
        }
        items[size] = x;
        size+=1;
    }

    public Item removeLast(){
        Item x = getLast(); //gives me the thing to be removed
        items[size-1] = null; //avoid loitering
        size -= 1;
        return x; //returns the thing "removed"

    }

    public Item getLast(){
        return items[size-1];
    }

    public Item get(int i){
        return items[i];
    }

    public int size(){
        return size;

    }

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


    public static void main(String args[]){
        AList L = new AList();
        int i = 0;
        while (i<5){
            L.addLast(i);
            i++;
        }
        L.addLast(5);
        L.insert(999,3);
        L.insert(1000,3);
        L.insert(1000,3);
        L.insert(1000,3);
        L.reverse();

        System.out.println("End");
    }
}
