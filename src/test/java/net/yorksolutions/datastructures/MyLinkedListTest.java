package net.yorksolutions.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void itShouldStartAtZeroSize() {
        assertEquals(0, new MyLinkedList<Integer>().size());
    }

    @Test
    void itShouldIncreaseSizeWhenItemAdded() {
        final var list = new MyLinkedList<Integer>();
        list.add(1);
        assertEquals(1, list.size());
        list.add(3);
        assertEquals(2, list.size());
    }

    @Test
    void itShouldSerialize() {
        final var list = new MyLinkedList<Integer>();
        list.add(4);
        assertEquals("[4, null] ", list.showMe());
    }

    @Test
    void itShouldDecreaseInSizeWhenItemRemoved() {
        final var list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.remove(2);
        assertEquals(1, list.size());
        list.remove(1);
        assertEquals(0, list.size());
    }

    @Test
    void itShouldNotDecreaseWhenAnItemThatDoesNotExistIsRemoved() {
        final var list = new MyLinkedList<Integer>();
        list.add(1);
        list.remove(2);
        assertEquals(1, list.size());
    }

    @Test
    void itShouldNotDecreaseWhenTheListIsEmpty() {
        final var list = new MyLinkedList<Integer>();
        list.remove(2);
        assertEquals(0, list.size());
    }

    @Test
    void isShouldSerializeWithAllItemsAdded() {
        final var list = new MyLinkedList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        assertEquals("[5, ->] [7, ->] [6, null] ", list.showMe());
    }

    @Test
    void isShouldSerializeWithoutAllItemsRemoved() {
        final var list = new MyLinkedList<Integer>();
        list.add(5);
        list.add(7);
        list.add(6);
        list.add(3);
        list.add(2);
        list.remove(6);
        assertEquals("[5, ->] [7, ->] [3, ->] [2, null] ", list.showMe());
    }
}