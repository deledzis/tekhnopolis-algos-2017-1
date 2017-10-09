package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayDeque<Item> implements collections.IDeque<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[]  elementData;
    private int     back;
    private int     front;
    private int     capacity;

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque() {
        elementData = (Item[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        front = back = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void pushFront(Item item) {
        if (isFull()) {
            grow();
        }
        front = front == 0 ? capacity - 1 : front - 1;
        elementData[front] = item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void pushBack(Item item) {
        if (isFull()) {
            System.out.println("size: " + size());
            grow();
        }
        elementData[back] = item;
        back = (back + 1) % capacity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Item popFront() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");

        Item tmp = elementData[front];
        elementData[front] = null;
        front = (front + 1) % capacity;

        if (capacity > DEFAULT_CAPACITY && capacity / size() > 4)
            shrink();
        else if (size() == 0)
            front = back = 0;

        return tmp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Item popBack() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");

        Item tmp = elementData[back];
        elementData[back] = null;
        back = back == 0 ? capacity - 1 : back - 1;

        if (capacity > DEFAULT_CAPACITY && capacity / size() > 4)
            shrink();
        else if (size() == 0)
            front = back = 0;

        return tmp;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isFull() {
        return size() == capacity - 1;
    }

    @Override
    public int size() {
        return (capacity - front + back) % capacity;
    }

    @Override
    public void print() {
        System.out.print("Deque [S: " + size() + "; C: " + capacity + "]: ");
        for (int i = front; i != back; i = (i + 1) % capacity) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println(" [F: " + front + "; B: " + back + "]");
    }

    public void printArray() {
        System.out.println(Arrays.toString(elementData));
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        System.out.println("before: " + capacity);
        Item[] tmp = (Item[]) new Object[(int) (capacity * 1.5)];
        for (int i = 0; i < capacity; i++) {
            int j = i + front;
            tmp[j] = elementData[j % capacity];
        }
        elementData = tmp;
        capacity *= 1.5;
        System.out.println("after: " + capacity);
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        Item[] tmp = (Item[]) new Object[capacity / 2];
        for (int i = 0; i < size(); i++) {
            tmp[i] = elementData[(i + front) % capacity];
        }
        elementData = tmp;
        front = 0;
        back = size() - 1;
        capacity /= 2;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CyclicArrayDequeIterator();
    }

    private class CyclicArrayDequeIterator implements Iterator<Item> {

        private int currentPosition = size();

        @Override
        public boolean hasNext() {
            System.out.println("hasNext");
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            System.out.println("next");
            return elementData[--currentPosition];
        }
    }
}
