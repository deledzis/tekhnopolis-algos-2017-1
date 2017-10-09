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

public class Main {

    public static void main(String[] args) {
        System.out.println("ArrayStack");
        IStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 30; i++) {
            stack.push(i);
        }
        stack.print();
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        stack.push(100);
        stack.print();
        System.out.println("LinkedStack");

        stack = new LinkedStack<>();
        for (int i = 0; i < 30; i++) {
            stack.push(i);
        }
        stack.print();
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        stack.push(100);
        stack.print();

        System.out.println("LinkedQueue");
        IQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
        }
        queue.print();
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        queue.enqueue(100);
        queue.print();

        System.out.println("TwoStackQueue");
        queue = new TwoStackQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
        }
        queue.print();
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        queue.enqueue(100);
        queue.print();

        System.out.println("CyclicArrayQueue");
        queue = new CyclicArrayQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue(i);
        }
        queue.print();
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        queue.enqueue(100);
        queue.print();

        System.out.println("LinkedDeque");
        IDeque<Integer> deque = new LinkedDeque<>();
        for (int i = 0; i < 15; i++) {
            deque.pushBack(i);
        }
        for (int i = 30; i > 10; i--) {
            deque.pushFront(i);
        }
        deque.print();
        for (int i = 0; i < 5; i++) {
            deque.popBack();
            deque.popFront();
        }
        deque.print();

        System.out.println("CyclicArrayDeque");
        deque = new CyclicArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            deque.pushFront(i);
            deque.pushBack(++i);
        }
        ((CyclicArrayDeque) deque).printArray();
        for (int i = 0; i < 5; i++) {
            deque.popBack();
            deque.popFront();
            ((CyclicArrayDeque) deque).printArray();
        }
        /*for (int i = 30; i > 10; i--) {
            deque.pushBack(i);
        }
        deque.print();
        for (int i = 0; i < 5; i++) {
            deque.popBack();
            deque.popFront();
        }
        deque.print();*/

       /* //System.out.println("Iterator 1");
        IncreasingIterator iterator1 = new IncreasingIterator(0, 5, 10);
       *//* IncreasingIterator tmp1 = iterator1;
        System.out.println("b4 1: " + tmp1.hasNext());
        for (int i = 0; i < 20; i++) {
            System.out.print(iterator1.next());
            if (i < 19) {
                System.out.print(" -> ");
            }
        }*//*
        //System.out.println();
        //System.out.println("Iterator 2");
        IncreasingIterator iterator2 = new IncreasingIterator(2, 4, 10);
        *//*IncreasingIterator tmp2 = iterator2;
        System.out.println("b4 2: " + tmp2.hasNext());
        for (int i = 0; i < 20; i++) {
            System.out.print(iterator2.next());
            if (i < 19) {
                System.out.print(" -> ");
            }
        }*//*
        System.out.println();
        System.out.println("Merging iterator");
        MergingIncreasingIterator increasingIterator = new MergingIncreasingIterator(iterator1, iterator2);
        //System.out.println("1: " + tmp1.hasNext() + "; 2: " + tmp2.hasNext());
        for (int i = 0; i < 30; i++) {
            System.out.print(increasingIterator.next());
            if (i < 19) {
                System.out.print(" -> ");
            }
        }*/
    }
}
