package seminar1.iterators;

import java.util.Iterator;
import java.util.Random;

/**
 * Итератор возвращающий возрастающую последовательность
 */
public class IncreasingIterator implements Iterator<Integer> {

    protected static char nextName = 'A';

    protected int curr;
    protected int step;
    protected final Random random;
    protected final String name;
    protected final int maxGrowth;
    protected final int valueLimit;
    protected final int stepLimit;

    public IncreasingIterator(int start, int maxGrowth, int stepLimit) {
        this.curr = start;
        this.maxGrowth = maxGrowth + 1; //because in random.nextInt(upperBound) — upperBound is exclusive
        this.name = nextName++ + "-";
        this.valueLimit = Integer.MAX_VALUE - maxGrowth;
        this.stepLimit = stepLimit == 0 ? Integer.MAX_VALUE : stepLimit;
        this.random = new Random();
    }

    @Override
    public boolean hasNext() {
        return curr < valueLimit && step < stepLimit;
    }

    @Override
    public Integer next() {
        int prev = curr;
        curr += random.nextInt(maxGrowth);
        step++;
        return prev;
    }

    public String getName() {
        return name;
    }
}
