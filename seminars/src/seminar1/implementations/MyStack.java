package seminar1.implementations;

import java.util.Iterator;
import seminar1.collections.IStack;

public class MyStack<T> implements IStack {
    private int mTop;
    private int mCapacity;
    private Object mArray[];

    public MyStack(int capacity) {
        mTop = -1;
        mCapacity = capacity;
        mArray = new Object[capacity];
    }

    private boolean isFull() {
        return this.mTop == this.mCapacity - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.mTop == - 1;
    }

    private void expand() {
        mCapacity *= 2;
        Object[] newArray = new Object[mCapacity];
        System.arraycopy(mArray, 0, newArray, 0, mArray.length);
        mArray = newArray;
    }

    @Override
    public void push(Object o) {
        if (isFull())
            expand();
        mArray[++mTop] = o;
    }

    @Override
    public Object pop() {
        if (isEmpty())
            return null;
        return mArray[mTop--];
    }
    
    @Override
    public int size() {
        return mTop;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < mTop;
            }

            @Override
            public Object next() {
                if (!hasNext()) throw new NullPointerException();
                return mArray[index++];
            }
        };
    }
}
