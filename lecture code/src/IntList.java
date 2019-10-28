public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;

    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }



    /****************** 这个很重要 *******************/
    public static IntList incrList(IntList L, int x) {
        /* I've used recurison, but iteration also works. */

        /* other base cases are possible */
        if (L == null) {
            return null;
        }

        /* You can do the two lines on one line, but I've opted
         * for two lines for maximum pedagogical clarity. */
        IntList incrementedList = new IntList(L.first + x, null);
        incrementedList.rest = incrList(L.rest, x);
        return incrementedList;
    }

    public static IntList dincrList(IntList L, int x) {
        /** Using recursion, but iteration also works. */
        if (L == null) {
            return null;
        }

        L.first = L.first - x;
        /* Don't actually care about the return value here. */
        dincrList(L.rest, x);

        return L;

    }

    public static void main (String []args)
    {


        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.get(2));
        System.out.println(incrList(L, 3).first);
        System.out.println(dincrList(L, 3).first);
    }

}
