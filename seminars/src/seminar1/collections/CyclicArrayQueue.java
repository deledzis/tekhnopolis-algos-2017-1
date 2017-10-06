package seminar1.collections;

import java.util.Iterator;

public class CyclicArrayQueue<Item> implements IQueue<Item> {

    private Item[] elementData;

    @Override
    public void enqueue(Item item) {
        /* TODO: implement it */
    }

    @Override
    public Item dequeue() {
        /* TODO: implement it */
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

    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it */
        return null;
    }
}
