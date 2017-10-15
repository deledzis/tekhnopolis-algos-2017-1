package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements IQueue<Item> {

    private Node<Item>  head;
    private Node<Item>  tail;
    private int         size;

    @Override
    public void enqueue(Item item) {
        Node<Item> tmp = head;
        head = new Node<>(item, null);

        if (isEmpty())
            tail = head;
        else
            tmp.next = head;
        size++;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");

        Item item = tail.item;
        tail = tail.next;
        size--;
        if (isEmpty()) head = null;
        return item;
    }

    public void print() {
        System.out.print("Queue:");
        this.forEach(Item -> System.out.print(" <- " + Item));
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Item> {
        private Node current = tail;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @SuppressWarnings("unchecked")
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Item item = (Item) current.item;
            current = current.next;
            return item;
        }

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}
