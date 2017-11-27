package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {

    private static final int DEFAULT_CAPACITY = 10;

    private Key[] elementData;
    private Comparator<Key> comparator;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        elementData = (Key[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
        comparator = Comparable::compareTo;
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Comparator<Key> comparator) {
        elementData = (Key[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
        this.comparator = comparator;
    }

    @Override
    public void add(Key key) {
        if (size == elementData.length)
            grow();

        elementData[size++] = key;
        siftUp(size - 1);   // sifting up as we changed structure of heap
    }

    private boolean isGreaterThanParent(int elementIndex) {
        return greater(getParentIndex(elementIndex), elementIndex);
    }

    private boolean compareToChildren(int elementIndex) {
        boolean needsToBeSiftedDown = false;

        if (getRightChildIndex(elementIndex) < size && getLeftChildIndex(elementIndex) < size) {
            // if one of the child is less than current element
            needsToBeSiftedDown = compareRightChild(elementIndex) || compareLeftChild(elementIndex);
        }

        return needsToBeSiftedDown;
    }

    private boolean compareRightChild(int elementIndex) {
        return !greater(getRightChildIndex(elementIndex), elementIndex);
    }

    private boolean compareLeftChild(int elementIndex) {
        return !greater(getLeftChildIndex(elementIndex), elementIndex);
    }

    private int getLeftChildIndex(int elementIndex) {
        return elementIndex * 2 + 1;
    }

    private int getRightChildIndex(int elementIndex) {
        return elementIndex * 2 + 2;
    }

    private int getParentIndex(int elementIndex) {
        return elementIndex % 2 == 0
                ?
                    elementIndex / 2 - 1
                :
                    (elementIndex + 1) / 2 - 1
                ;
    }

    @Override
    public Key peek() {
        return elementData[0];
    }

    @Override
    public Key extractMin() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty.");

        if (size() * 4 <= elementData.length)
            shrink();

        Key key = elementData[0]; // peeking last then
        swap(size - 1, 0); // swapping first and last elements
        elementData[--size] = null; // removing it from heap
        siftDown(0); // sifting down as we changed structure of heap

        return key;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {
        System.out.print("Heap: ");
        //print values
        this.forEach(Item -> System.out.print(Item + " "));
        System.out.println();
    }

    private void swap(int indexOfFirstElement, int indexOfSecondElement) {
        Key key = elementData[indexOfFirstElement];
        elementData[indexOfFirstElement] = elementData[indexOfSecondElement];
        elementData[indexOfSecondElement] = key;
    }

    private void siftUp(int elementIndex) {
        if (elementIndex == 0)
            return;

        while (isGreaterThanParent(elementIndex)) {
            swap(elementIndex, getParentIndex(elementIndex));
            elementIndex = getParentIndex(elementIndex);
            if (elementIndex == 0) {
                break;
            }
        }
    }

    private void siftDown(int elementIndex) {
        if (getRightChildIndex(elementIndex) < size){
            Key leftChild = elementData[getLeftChildIndex(elementIndex)];
            Key rightChild = elementData[getRightChildIndex(elementIndex)];

            if (comparator.compare(leftChild, rightChild) > 0) {
                swap(elementIndex, getRightChildIndex(elementIndex));
            }
            else {
                swap(elementIndex, getLeftChildIndex(elementIndex));
            }
        }
        else if (getLeftChildIndex(elementIndex) < size && compareLeftChild(elementIndex)) {
            swap(elementIndex, getLeftChildIndex(elementIndex));
        }

        if (compareToChildren(getRightChildIndex(elementIndex))) {
            siftDown(getRightChildIndex(elementIndex));
        }
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

    // returns 1 if first is greater than second, 0 otherwise
    private boolean greater(int first, int second) {
        return comparator == null
                ?
                    elementData[first].compareTo(elementData[second]) > 0           // using default comparator
                :
                    comparator.compare(elementData[first], elementData[second]) > 0 // using custom comparator
                ;
    }

    @Override
    public Iterator<Key> iterator() { return new ArrayPriorityQueueIterator();}

    private class ArrayPriorityQueueIterator implements Iterator<Key> {

        private int currentPosition = 0;

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Key next() {
            return elementData[currentPosition++];
        }
    }
}