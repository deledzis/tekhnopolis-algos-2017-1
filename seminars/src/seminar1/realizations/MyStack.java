package seminar1.realizations;

import java.util.Iterator;
import java.util.function.Consumer;

import seminar1.collections.IStack;

public class MyStack implements IStack<Integer> {
    private int mTop;
    private int mCapacity;
    private int mArray[];

    public MyStack(int capacity) {
        mTop = -1;
        mCapacity = capacity;
        mArray = new int[capacity];
    }

    private boolean isFull() {
        return this.mTop == this.mCapacity - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.mTop == - 1;
    }

    @Override
    public void push(Integer o) {
        if (isFull())
            return;
        mArray[++mTop] = o;
    }

    @Override
    public Integer pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return mArray[mTop--];
    }
    
    @Override
    public int size() {
        return mTop;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }

            @Override
            public void remove() {

            }

            @Override
            public void forEachRemaining(Consumer action) {

            }
        }
        return null;
    }
}
