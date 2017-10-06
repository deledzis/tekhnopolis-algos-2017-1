package seminar1.realizations;

import java.util.Iterator;
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
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < mTop;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NullPointerException();
                return mArray[index++];
            }
        };
    }
}
