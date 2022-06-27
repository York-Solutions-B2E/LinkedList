package net.yorksolutions.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;

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

    // by convection, data structures in java have a size() method that
    //    returns the number of items in that data structure
    public int size() {
        return numberOfItems;
    }

    /*
    5, 7, 2, 8

    [5, ->]
     */

    private static class Box {
        int value;
        Box box = null;
    }

    public void add(int item) {
        ++numberOfItems;


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
        System.out.println(myLinkedList.size());
    }
}
