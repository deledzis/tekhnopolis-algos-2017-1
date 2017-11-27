package iterators;

import java.util.Iterator;

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
    private Integer currElementFromFirst;
    private Integer currElementFromSecond;
    private Integer elementToBeReturned;
    private Integer iteratorToBeIterated;
    private Boolean firstIteration;

    public MergingIncreasingIterator(IncreasingIterator first, IncreasingIterator second) {
        this.first = first;
        this.second = second;
        firstIteration = true;
    }

    @Override
    public boolean hasNext() {
        return first.hasNext() || second.hasNext() || currElementFromFirst != null || currElementFromSecond != null;
    }

    @Override
    public Integer next() {
        if (firstIteration) {
            currElementFromFirst = first.next();
            currElementFromSecond = second.next();
            iteratorToBeIterated = currElementFromFirst <= currElementFromSecond
                    ? 0  // 0 is for the first iterator,
                    : 1; // 1 is for the second
            firstIteration = false;
        }
        if (iteratorToBeIterated % 2 == 0) {
            if (currElementFromSecond == null ||  currElementFromFirst <= currElementFromSecond) {
                elementToBeReturned = currElementFromFirst;
                if (first.hasNext()) {
                    currElementFromFirst = first.next();
                }
                else {
                    currElementFromFirst = null;
                    iteratorToBeIterated++;
                }
            }
            else {
                iteratorToBeIterated++;
            }
        }
        else {
            if (currElementFromFirst == null || currElementFromSecond <= currElementFromFirst) {
                elementToBeReturned = currElementFromSecond;
                if (second.hasNext()) {
                    currElementFromSecond = second.next();
                }
                else {
                    currElementFromSecond = null;
                    iteratorToBeIterated++;
                }
            }
            else {
                iteratorToBeIterated++;
            }
        }
        return elementToBeReturned;
    }
}
