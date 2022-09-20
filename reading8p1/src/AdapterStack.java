import java.util.List;

/*This one makes a stack that can be any type of List that implements the List interface
* Linked Lists, ArrayList, etc.*/
public class AdapterStack<Item>{
    private List L;
    public AdapterStack(List<Item> worker){
        L = worker;
    }

    public void push(Item x){
        L.add(x);
    }
}
