package practice2_package;

public class VengefulSLList <Item> extends SLList <Item>{
    SLList<Item> deletedItems;

    public VengefulSLList(){
        super(); //will call this if you don't specify a constructor with a parameter like below
        deletedItems = new SLList<Item>();
    }

    public VengefulSLList(Item x){
        super(x);
        deletedItems = new SLList<Item>();
    }

    /*subclasses cannot access private attributes or nested classes from super*/
    @Override
    public Item removeLast(){
        Item del = super.removeLast();
        deletedItems.addLast(del);
        return del;
    }

    public void printLostItems() {
        deletedItems.print();
    }
}
