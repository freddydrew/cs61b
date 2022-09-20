import java.util.LinkedList;

/*This makes a stack but creates a LinkedLists and exploits its methods to accomplish its goal*/
public class DelegationStack<Item>{
    private LinkedList<Item> L = new LinkedList<>();
    public void push(Item x){
        L.add(x);
    }
}