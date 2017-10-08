package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayQueue<Item> implements IQueue<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int readPtr;
    private int writePtr;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue() {
        readPtr = 0;
        writePtr = 0;
        elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(Item item) {
        if (isFull())
            grow();
        elementData[writePtr] = item;
        writePtr = (writePtr + 1) % elementData.length;
    }

    @Override
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        if (elementData.length >= DEFAULT_CAPACITY && elementData.length / size() > 4)
            shrink();
        Item tmp = elementData[readPtr];
        elementData[readPtr] = null;
        readPtr = (readPtr + 1) % elementData.length;
        return tmp;
    }

    private boolean isFull() {
        return readPtr == (writePtr + 1 ) % elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return readPtr == writePtr;
    }

    @Override
    public int size() {
        return (elementData.length - readPtr + writePtr) % elementData.length;
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
        changeCapacity((int) (elementData.length * 1.5));
    }

    private void shrink() {
        changeCapacity(elementData.length / 2);
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
