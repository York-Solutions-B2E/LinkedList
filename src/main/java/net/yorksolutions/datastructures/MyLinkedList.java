package net.yorksolutions.datastructures;

// is a data structure
// a data structure is a thing that stores stuff in a useful way
// Low cost to insert
// no limit to its size
// low cost to remove the first piece of data
// low cost to remove the last piece of data
// high cost to search
// low cost to remove an item in the middle
public class MyLinkedList<T> {
    // keep track of how many items are in this linked list
    private int numberOfItems = 0;
    private Box<T> theFirstBox = null;

    // by convection, data structures in java have a size() method that
    //    returns the number of items in that data structure
    public int size() {
        return numberOfItems;
    }

    /*
    5, 7, 2, 8


    [5, ->] [7, ->] [2, null]
     */

    private static class Box<T> {
        T value;
        Box<T> theNextBox = null; // location of next box, if no box, then null

        Box(T value) {
            this.value = value;
        }
    }

    public void add(T item) {
        Box<T> box = new Box<T>(item);

        if (numberOfItems == 0)
            theFirstBox = box;
        else {
            Box<T> theLastBox = theFirstBox;

            while (theLastBox.theNextBox != null) {
                theLastBox = theLastBox.theNextBox;
            }

            theLastBox.theNextBox = box;
        }

        ++numberOfItems;
    }

    public String showMe() {
        String result = "";
        Box<T> current = theFirstBox;

        while (current != null) {
            String ptr;

            if (current.theNextBox == null)
                ptr = "null";
            else
                ptr = "->";

            result += "[" + current.value + ", " + ptr + "] ";
            current = current.theNextBox;
        }

        return result;
    }

    public void remove(int thisSpecificOne) {
        if (numberOfItems > 0)
            --numberOfItems;
    }

    public static void main(String[] args) {
        /*
        [
        0 -> 0-255
        1 -> 0-255
        3 -> 0-255
        ...
        32000000000 -> 0-255
        ]
         */
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(4);
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.showMe()); //[5, ->] [6, ->] [4, null]
        myLinkedList.remove(5);
        System.out.println(myLinkedList.showMe()); //[6, ->] [4, null]
    }
}
