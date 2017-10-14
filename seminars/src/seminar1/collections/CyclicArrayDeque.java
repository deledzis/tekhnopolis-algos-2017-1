package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayDeque<Item> implements collections.IDeque<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[]  elementData;
    private int     back;
    private int     front;
    private int     capacity;
    private int     size;

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque() {
        elementData     = (Item[]) new Object[DEFAULT_CAPACITY];
        capacity        = DEFAULT_CAPACITY;
        front    = back = 0;
        size            = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void pushFront(Item item) {
        if (isFull()) grow();

        front = front == 0
                ? capacity - 1
                : front - 1;
        elementData[front] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void pushBack(Item item) {
        if (isFull()) grow();

        elementData[back] = item;
        back = (back + 1) % capacity;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Item popFront() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");

        front = (front + 1) % capacity;
        Item tmp = elementData[front];
        elementData[front] = null;

        if (capacity > DEFAULT_CAPACITY && capacity / size > 4)
            shrink();
        else if (size == 0)
            front = back = 0;
        size--;

        return tmp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Item popBack() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty");

        Item tmp = elementData[back];
        elementData[back] = null;
        back = back == 0 ? capacity - 1 : back - 1;

        if (capacity > DEFAULT_CAPACITY && capacity / size > 4)
            shrink();
        else if (size == 0)
            front = back = 0;
        size--;

        return tmp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return front > back ? (capacity - front + back) : (back - front);
    }

    @Override
    public void print() {
        System.out.print("[S: " + size + "; C: " + capacity + "]: [ ");
        this.forEach(Item -> System.out.print(Item + " "));
        System.out.println("] [F: " + front + "; B: " + back + "]");
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        Item[] tmp  = (Item[]) new Object[(int) (capacity * 1.5)];
        for (int i  = 0; i < capacity; i++) {
            int j   = i + front;
            tmp[i]  = elementData[j % capacity];
        }
        elementData = tmp;
        front       = 0;
        back        = capacity;
        capacity    *= 1.5;
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        Item[] tmp     = (Item[]) new Object[capacity / 2];
        for (int i  = 0; i < size; i++) {
            tmp[i]  = elementData[(i + front) % capacity];
        }
        elementData = tmp;
        front       = 0;
        back        = size - 1;
        capacity    /= 2;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CyclicArrayDequeIterator();
    }

    private class CyclicArrayDequeIterator implements Iterator<Item> {

        private int currentPosition = front > back ? front - 1 : front;

        @Override
        public boolean hasNext() {
            if (front > back) {
                return currentPosition != back - 1;
            }
            else {
                return currentPosition != back;
            }
        }

        @Override
        public Item next() {
            return elementData[currentPosition = (currentPosition + 1) % capacity];
        }
    }
}
