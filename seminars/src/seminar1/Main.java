import collections.ArrayStack;
import collections.IQueue;
import collections.IStack;
import collections.LinkedQueue;
import collections.LinkedStack;
import collections.TwoStackQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("ArrayStack");
        IStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < 30; i++) {
            stack.push((char) (i + 35));
        }
        stack.print();
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        stack.push('n');
        stack.print();
        System.out.println("LinkedStack");

        stack = new LinkedStack<>();
        for (int i = 0; i < 30; i++) {
            stack.push((char) (i + 35));
        }
        stack.print();
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        stack.push('n');
        stack.print();

        System.out.println("LinkedQueue");
        IQueue<Character> queue = new LinkedQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue((char) (i + 35));
        }
        queue.print();
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        queue.enqueue('n');
        queue.print();

        System.out.println("TwoStackQueue");
        queue = new TwoStackQueue<>();
        for (int i = 0; i < 30; i++) {
            queue.enqueue((char) (i + 35));
        }
        queue.print();
        queue.enqueue('n');
        queue.print();
/*        System.out.println("LinkedStack");
        IStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
//        for (int i : stack) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("LinkedQueue");
        IQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
//        for (int i : queue) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("TwoStackQueue");
        queue = new TwoStackQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 30; i++) {
            System.out.print(queue.dequeue() + " ");
        }*/
    }
}
