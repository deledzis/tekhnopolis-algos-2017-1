package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<Item> implements IDeque<Item> {

    // -> [tail -> .. -> .. -> head] ->
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    @Override
    public void pushFront(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node<Item> newFirst = new Node<>(item);
        if (first != null) {
            newFirst.next = first;
            first.previous = newFirst;
        }
        first = newFirst;
        if (last == null) last = first;
        size++;
    }

    @Override
    public void pushBack(Item item) {
        if (item == null)
            throw new NullPointerException();

        Node<Item> newLast = new Node<>(item);
        if (last != null) {
            newLast.previous = last;
            last.next = newLast;
        }
        last = newLast;
        if (first == null) first = last;
        size++;
    }

    @Override
    public Item popFront() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<Item> oldFirst = first;
        first = first.next;
        if (first == null)
            last = null;
        else
            first.previous = null;
        size--;

        return oldFirst.item;
    }

    @Override
    public Item popBack() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<Item> oldLast = last;
        last = oldLast.previous;
        if (last == null)
            first = null;
        else
            last.next = null;
        size--;

        return oldLast.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Node<Item> iterNode = first;
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
