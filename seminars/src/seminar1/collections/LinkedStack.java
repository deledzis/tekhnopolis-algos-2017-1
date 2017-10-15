package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item>  head;
    private int         size;

    public LinkedStack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(Item item) {
        head = new Node<>(item, head);
        size++;
    }

    @Override
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");

        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public void print() {
        System.out.print("Stack [S: " + size + "]: [");
        this.forEach(Item -> System.out.print(" <- " + Item));
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return size == 0 || head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {
        private Node<Item> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("Stack is empty");

            Item item = current.item;
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
