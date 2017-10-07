package collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<Item> implements collections.IStack<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        capacity = DEFAULT_CAPACITY;
        this.elementData = (Item[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void push(Item item) {
        if (isFull()) {
            grow();
        }
        elementData[size++] = item;
    }

    @Override
    public Item pop() {
        if (capacity / size > 4) {
            shrink();
        }
        Item item = elementData[--size];
        elementData[size] = null;
        return item;
    }

    public Item peek() {
        return elementData[size - 1];
    }

    public void print() {
        System.out.print("Stack: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
    }

    private boolean isFull() {
        return size() == capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        changeCapacity(capacity *= 1.5);
    }

    private void shrink() {
        changeCapacity(capacity /= 2);
    }

    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            return elementData[--currentPosition];
        }
    }
}
