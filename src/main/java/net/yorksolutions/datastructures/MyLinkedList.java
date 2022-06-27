package net.yorksolutions.datastructures;

// is a data structure
// a data structure is a thing that stores stuff in a useful way
// Low cost to insert
// no limit to its size
// low cost to remove the first piece of data
// low cost to remove the last piece of data
// high cost to search
// low cost to remove an item in the middle
public class MyLinkedList {
    // keep track of how many items are in this linked list
    private int numberOfItems = 0;
    private Box theFirstBox = null;

    // by convection, data structures in java have a size() method that
    //    returns the number of items in that data structure
    public int size() {
        return numberOfItems;
    }

    /*
    5, 7, 2, 8


    [5, ->] [7, ->] [2, null]
     */

    private static class Box {
        int value;
        Box theNextBox = null; // location of next box, if no box, then null

        Box(int value) {
            this.value = value;
        }
    }

    public void add(int item) {
        Box box = new Box(item);

        if (numberOfItems == 0)
            theFirstBox = box;
        else {
            Box theLastBox = theFirstBox;

            while (theLastBox.theNextBox != null) {
                theLastBox = theLastBox.theNextBox;
            }

            theLastBox.theNextBox = box;
        }

        ++numberOfItems;
    }

    public void showMe() {
        Box current = theFirstBox;

        while (current != null) {
            String ptr;

            if (current.theNextBox == null)
                ptr = "null";
            else
                ptr = "->";

            System.out.print("[" + current.value + ", " + ptr + "] ");
            current = current.theNextBox;
        }
    }

    public void remove(int thisSpecificOne) {
        // do it
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
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.add(4);
        System.out.println(myLinkedList.size());
        myLinkedList.showMe(); //[5, ->] [6, ->] [4, null]
        myLinkedList.remove(5);
        myLinkedList.showMe(); //[6, ->] [4, null]
    }
}
