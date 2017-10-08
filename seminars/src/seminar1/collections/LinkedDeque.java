package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<Item> implements IDeque<Item> {

    private Node<Item> back;
    private Node<Item> front;
    private int size;

    @Override
    public void pushFront(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node<Item> newLast = new Node<>(item);
        if (front != null) {
            newLast.previous = front;
            front.next = newLast;
        }
        front = newLast;
        if (back == null) back = front;

        size++;
    }

    @Override
    public void pushBack(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node<Item> newFirst = new Node<>(item);
        if (back != null) {
            newFirst.next = back;
            back.previous = newFirst;
        }
        back = newFirst;
        if (front == null) front = back;

        size++;
    }

    @Override
    public Item popFront() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<Item> oldFirst = back;
        back = back.next;
        if (back == null)
            front = null;
        else
            back.previous = null;
        size--;

        return oldFirst.item;
    }

    @Override
    public Item popBack() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<Item> oldLast = front;
        front = oldLast.previous;
        if (front == null)
            back = null;
        else
            front.next = null;
        size--;

        return oldLast.item;
    }

    @Override
    public boolean isEmpty() {
        return back == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Node<Item> iterNode = back;
        System.out.print("Deque: ");
        for (int i = 0; i < size; i++) {
            System.out.print(iterNode.item);
            if (i < size - 1) {
                System.out.print(" -> ");
            }
            iterNode = iterNode.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedDequeIterator();
    }

    private class LinkedDequeIterator implements Iterator<Item> {
        private Node<Item> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null)
                throw new NoSuchElementException();

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> previous;

        Node(Item item) {
            this.item = item;
        }
    }
}
