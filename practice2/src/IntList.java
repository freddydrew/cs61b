public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public static int sizeIterative(IntList L){
        int s = 1;
        if (L.rest == null){
            return s;
        }
        IntList tmp = L;
        while (tmp.rest != null){
            s++;
            tmp = tmp.rest;
        }
        System.out.println("SizeIterative: " + s);
        return s;
    }

    public static int sizeRecursive(IntList L){
        if (L.rest == null){
            return 1;
        } else {
            return 1 + sizeRecursive(L.rest);
        }
    }

    public static void PrintVars(IntList L){
        System.out.print( "Linked List elements: ");
        IntList tmp = L;
        while (tmp.rest != null){
            System.out.print(tmp.first + " ");
            tmp = tmp.rest;
        }
        System.out.print(tmp.first + " ");
        System.out.println();
    }

    public static void addLast(int x, IntList L){
        IntList tmp = L;
        while (tmp.rest != null){
            tmp = tmp.rest;
        }
        tmp.rest = new IntList(x,null);
    }

    public static IntList addFirst(int x, IntList L){
        return new IntList(x,L);
    }

    public void insert(int x, int idx){
        IntList tmp = this;
        int count = 0;
        while (count != idx - 1 && count != idx){
            tmp = tmp.rest;
            count++;
        }
        tmp.rest = new IntList(x,tmp.rest);
    }

    public static IntList incrList(IntList L, int x){
        if (L.rest == null){
            return new IntList(L.first + x, null);
        } else {
            return new IntList(L.first+x,incrList(L.rest,x));
        }
    }

    public static IntList dincrList(IntList L, int x){
        if (L.rest == null){
            L.first += x;
            return L;
        } else {
            L.first += x;
            L.rest = incrList(L.rest,x);
            return L;
        }
    }

    /*exam prep 3 question 2*/
    public void skippify(){
        IntList p = this;
        int n = 1;
        while (p != null){
            IntList next = p.rest;
            for (int i = 0; i <= n; i++){
                if (i == n){
                    p.rest = next;
                } else {
                    if (next == null){
                        p.rest = null;
                        break;
                    }
                    next = next.rest;
                }
            }
            n++;
            p = p.rest;
        }
    }

    /*exam prep 3 question 3a */
    public static IntList ilsans(IntList x, int y){
        /*null check always first base-case?*/
        if (x == null){
            return x;
        }
        if (x.first == y){
            return ilsans(x.rest,y);
        }
        return new IntList(x.first,ilsans(x.rest,y));
    }

    /*exam prep 3 question 3b */
    public static IntList dilsans(IntList x, int y){
        /*null check always first base-case?*/
        if (x == null){
            return x;
        }
        IntList tmp = x.rest;
        if (x.first == y){
            return dilsans(tmp,y);
        }
        return dilsans(x.rest,y);
    }
    public static void main(String args[]){
        IntList L = new IntList(15,null);
        L = new IntList(10,L);
        L = new IntList(5,L);
        int sizeIt = sizeIterative(L);
        int sizeRe = sizeRecursive(L);
        System.out.println("SizeRecursive: " + sizeRe);
        PrintVars(L);
//        addLast(20, L);
//        addLast(25, L);
        addLast(30, L);
        addLast(30, L);
        addLast(30, L);
//        addLast(35, L);
//        addLast(40, L);

        PrintVars(L);
        L = addFirst(0,L);
        PrintVars(L);
        sizeIt = sizeIterative(L);
        sizeRe = sizeRecursive(L);
        System.out.println("SizeRecursive: " + sizeRe);
        L.insert(12,3);
        PrintVars(L);
//        IntList Q = incrList(L,2);
//        PrintVars(Q);
//        IntList P = dincrList(L,1);
//        PrintVars(P);
//        L.skippify();
//        IntList F = ilsans(L,30);
        L = dilsans(L,30);
        System.out.println("END");
    }

}
