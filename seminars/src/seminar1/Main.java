import java.util.Iterator;

import collections.ArrayStack;
import collections.CyclicArrayDeque;
import collections.CyclicArrayQueue;
import collections.IDeque;
import collections.IQueue;
import collections.IStack;
import collections.LinkedDeque;
import collections.LinkedQueue;
import collections.LinkedStack;
import collections.TwoStackQueue;
import iterators.IncreasingIterator;
import iterators.MergingIncreasingIterator;

public class Main {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        System.out.println("ArrayStack");
        System.out.println("==========");
        testStack(new ArrayStack<>());
        System.out.println();

        System.out.println("LinkedStack");
        System.out.println("==========");
        testStack(new LinkedStack<>());
        System.out.println();

        System.out.println("LinkedQueue");
        System.out.println("==========");
        testQueue(new LinkedQueue<>());
        System.out.println();

        System.out.println("TwoStackQueue");
        System.out.println("==========");
        testQueue(new TwoStackQueue<>());
        System.out.println();

        System.out.println("CyclicArrayQueue");
        System.out.println("==========");
        testQueue(new CyclicArrayQueue<>());
        System.out.println();

        System.out.println("LinkedDeque");
        System.out.println("==========");
        testDeque(new LinkedDeque<>());
        System.out.println();

        System.out.println("CyclicArrayDeque");
        System.out.println("==========");
        testDeque(new CyclicArrayDeque<>());
        System.out.println();

        System.out.println("MergingIncreasingIterator");
        System.out.println("==========");
        testIterator(new MergingIncreasingIterator(
                new IncreasingIterator(0, 5, 5),
                new IncreasingIterator(4, 6, 10)
        ));
        System.out.println();
    }

    private static void testStack(IStack<Integer> stack) {
        for (int i = 0; i < 100; i++)
            stack.push(i);

        stack.print();

        for (int i = 0; i < 20; i++)
            stack.pop();

        stack.push(100);
        stack.print();
    }

    private static void testQueue(IQueue<Integer> queue) {
        for (int i = 0; i < 30; i++)
            queue.enqueue(i);

        queue.print();

        for (int i = 0; i < 5; i++)
            queue.dequeue();

        queue.enqueue(100);
        queue.print();
    }

    private static void testDeque(IDeque<Integer> deque) {
        for (int i = 0; i < 100; i++) {
            deque.pushFront(i);
            deque.pushBack(++i);
        }

        deque.print();

        for (int i = 0; i < 20; i++) {
            deque.popBack();
            deque.popFront();
        }

        deque.print();
    }

    private static void testIterator(Iterator<Integer> iterator) {
        iterator.forEachRemaining(x -> {
            System.out.print(x + " -> ");
        });
    }
}