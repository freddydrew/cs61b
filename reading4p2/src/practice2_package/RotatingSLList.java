package practice2_package;

public class RotatingSLList<Item> extends SLList<Item>{

    /*rotates list to the right, pop last and stick it on the front*/
    public void rotateRight(){
        Item tmp = removeLast();
        addFirst(tmp);
    }
}
