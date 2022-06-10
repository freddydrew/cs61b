/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> {
    private int size;
    private Item[] items;

    /** Creates an empty list. */
    public AList() {
        size = 0;
        items = (Item[]) new Object[100];
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if (size == items.length){
            resize(size + 1);
        }
            items[size] = x;
            size += 1;
    }

    public void resize(int capacity){
        Item[] a = (Item[] )new Object[capacity];
        System.arraycopy(items,0,a,0,capacity);
        items = a;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast() {
        Item last = getLast();
        items[size - 1] = null;
        size -= 1;
        return last;
    }


    public static void main(String args[]){
        AList A = new <Integer>AList();
        A.addLast(1);
        A.addLast(1);
    }
} 