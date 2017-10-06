package seminar1.collections;

import java.util.Iterator;

public class TwoStackQueue<Item> implements IQueue<Item> {

    private IStack<Item> stack1;
    private IStack<Item> stack2;

    public TwoStackQueue() {
        /* TODO: implement it */
    }

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
        return true;
    }

    @Override
    public int size() {
        /* TODO: implement it */
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        /* TODO: implement it (optional) */
        return null;
    }

}
