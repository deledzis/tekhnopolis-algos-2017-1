package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CyclicArrayDeque<Item> implements collections.IDeque<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int  back;
    private int  front;

    @SuppressWarnings("unchecked")
    public CyclicArrayDeque() {
        elementData = (Item[]) new Object[DEFAULT_CAPACITY];
        front = back = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void pushFront(Item item) {
        back++;
        if (isFull())
            grow();
        Item[] tmp = (Item[]) new Object[elementData.length];
        System.arraycopy(elementData, 0, tmp, 0, size());
        elementData = tmp;
        System.arraycopy(elementData, front, elementData, front + 1, size() + 1 - front);
        elementData[front] = item;
        front = front % elementData.length;
    }

    @Override
    public void pushBack(Item item) {
        if (isFull())
            grow();
        elementData[back++] = item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Item popFront() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");

        if (elementData.length >= DEFAULT_CAPACITY && elementData.length / size() > 4)
            shrink();
        Item[] tmp = (Item[]) new Object[elementData.length];
        System.arraycopy(elementData, 1, tmp, 0, size() - 1);
        elementData = tmp;
        front++;
        return elementData[front - 1];
    }

    @SuppressWarnings("unchecked")
    @Override
    public Item popBack() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty");

        if (elementData.length >= DEFAULT_CAPACITY &&  size() / elementData.length > 4)
            shrink();
        Item[] tmp = (Item[]) new Object[elementData.length];
        //System.arraycopy(elementData, front, tmp, front, size() - 1 - front);
        for(int i = front; i < size() - 1; i++){
            tmp[i] = elementData[i];
        }
        elementData = tmp;
        back--;
        return elementData[back];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isFull() {
        return size() == elementData.length - 1;
    }

    @Override
    public int size() {
        return back - front;
    }

    @Override
    public void print() {
        System.out.print("Deque [S: " + size() + "; C: " + elementData.length + "]: ");
        for (int i = 0; i < size(); i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println(" [F: " + front + "; B: " + back + "]");
    }

    public void printArray() {
        System.out.println(Arrays.toString(elementData));
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
