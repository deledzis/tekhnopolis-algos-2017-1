package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayQueue<Item> implements IQueue<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int readPtr;
    private int writePtr;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue() {
        readPtr = 0;
        writePtr = 0;
        capacity = DEFAULT_CAPACITY;
        elementData = (Item[]) new Object[capacity];
    }

    @Override
    public void enqueue(Item item) {
        if (isFull())
            grow();
        elementData[writePtr] = item;
        writePtr = (writePtr + 1) % capacity;
    }

    @Override
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        if (capacity / size() > 4)
            shrink();
        Item tmp = elementData[readPtr];
        elementData[readPtr] = null;
        readPtr = (readPtr + 1) % capacity;
        return tmp;
    }

    private boolean isFull() {
        return readPtr == (writePtr + 1 ) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return readPtr == writePtr;
    }

    @Override
    public int size() {
        return (capacity - readPtr + writePtr) % capacity;
    }

    @Override
    public void print() {
        System.out.print("Stack: ");
        for (int i = readPtr; i < readPtr + size(); i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
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

        private int currentPosition = size();

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
