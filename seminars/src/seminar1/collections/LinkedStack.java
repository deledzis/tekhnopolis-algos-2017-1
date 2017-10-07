package collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item> head;
    private int size;

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
        if (isEmpty()) throw new NullPointerException("Stack is empty");
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public Item peek() {
        return head.item;
    }

    public void print() {
        Node<Item> iterNode = head;
        System.out.print("Stack: ");
        for (int i = 0; i < size; i++) {
            System.out.print(iterNode.item + " ");
            iterNode = iterNode.next;
        }
        System.out.println();
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
            if (!hasNext()) throw new NullPointerException("Stack is empty");
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
