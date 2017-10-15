package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор возвращающий последовательность из двух возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 *
 * Time = O(k),
 *  k — суммарное количество элементов
 */
public class MergingIncreasingIterator implements Iterator<Integer> {

    private IncreasingIterator first;
    private IncreasingIterator second;

    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;
        /* TODO: implement it */
    }

    @Override
    public boolean hasNext() {
        return first.hasNext() || (second != null && second.hasNext());
    }

    @Override
    public Integer next() {
        if (first.hasNext()) {
            Integer ret = first.next();
            if (second != null) {
                IncreasingIterator tmp = second;
                second = first;
                first = tmp;
            }
            return ret;
        }
        else {
            if (second == null || !second.hasNext()) {
                throw new NoSuchElementException();
            }
            first = second;
            second = null;
            return second.next();
        }
    }
}
