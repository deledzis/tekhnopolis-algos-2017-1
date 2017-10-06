package seminar1.collections;

import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {

    private Key[] elementData;
    private Comparator<Key> comparator;

    public ArrayPriorityQueue() {
        /* TODO: implement it — O(n) */
    }

    public ArrayPriorityQueue(Comparator<Key> comparator) {
        /* TODO: implement it — O(n) */
        this.comparator = comparator;
    }

    @Override
    public void add(Key key) {
        /* TODO: implement it — O(log n) */
    }

    @Override
    public Key peek() {
        /**
         * TODO: implement it — O(1)
         * Посмотреть на минимальный элемент
         */
        return null;
    }

    @Override
    public Key extractMin() {
        /**
         * TODO: implement it — O(log n)
         * Достать минимальный элемент
         *  и перестроить кучу
         */
        return null;
    }

    @Override
    public boolean isEmpty() {
        /* TODO: implement it */
        return false;
    }

    @Override
    public int size() {
        /* TODO: implement it */
        return 0;
    }

    private void siftUp() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вверх —
         *  подъём элемента больше родителей
         */
    }

    private void siftDown() {
        /**
         * TODO: implement it — O(log n)
         * Просеивание вниз
         *  спуск элемента меньше детей
         */
    }

    private void grow() {
        /**
         * TODO: implement it
         * Если массив заполнился,
         * то увеличить его размер в полтора раз
         */
    }

    private void shrink() {
        /**
         * TODO: implement it
         * Если количество элементов в четыре раза меньше,
         * то уменьшить его размер в два раза
         */
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elementData[i].compareTo(elementData[j]) > 0
                : comparator.compare(elementData[i], elementData[j]) > 0
                ;
    }

    @Override
    public Iterator<Key> iterator() {
        /* TODO: implement it */
        return null;
    }
}
