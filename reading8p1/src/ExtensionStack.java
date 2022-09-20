import java.util.LinkedList;

/**A stack class that borrows methods of LinkedList through extension*/
public class ExtensionStack<Item> extends LinkedList<Item> {
    public void push(Item x){
        add(x);
    }
}


