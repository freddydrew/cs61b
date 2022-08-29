package practice2_package;

/*Interface describes all the things that Lists should be able to do, identifies lists of all kinds in java.
 * Interfaces are enacted in a given class that fits the description with the interacts keyword*/
public interface List61B<Item> {

    /*Constructors don't come here, no private methods, no attributes.
     * Notice that only the public lists get kept or mentioned in the interface.
     * The @Override tag must be used on all methods that are in the interface when writing classes.
     * The interface describes all the things that the list will inherit. */

    /*
    * void addFirst(item x)
    * void addLast(item x)
    * item getFirst()
    * item getLast()
    * item removeLast()
    * item get(int x)
    * void insert(item x, int pos)
    * int size()*/


    /*all lists have addFirst*/
    public void addFirst(Item x);

    /*basically saying all lists should be able to addLast*/
    public void addLast(Item x);

    /*all lists have getFirst*/
    public Item getFirst();

    /*basically saying all lists should be able to getLast*/
    public Item getLast();

    /*all lists have removeLast*/
    public Item removeLast();

    /*basically saying all lists should be able to get*/
    public Item get(int x);

    /*all lists should have an insert method*/
    public void insert(Item x, int pos);

    /*all lists have size*/
    public int size();

    /*default method that the subclasses inherit*/
    /*dynamic type's method gets priority if @Override is used.*/
    /*prints entire list*/
    default public void print(){
        int len = size();
        for (int i = 0; i < len; i++){
            System.out.print(get(i)+ " ");
        }
        System.out.println();
    }

}
