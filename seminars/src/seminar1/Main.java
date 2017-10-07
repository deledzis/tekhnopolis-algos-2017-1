import collections.ArrayStack;
import collections.LinkedStack;

public class Main {

    public static void main(String[] args) {
        System.out.println("=ArrayStack=");
        ArrayStack<Character> astack = new ArrayStack<>();
        for (int i = 0; i < 30; i++) {
            astack.push((char) (i + 35));
        }
        astack.print();
        astack.pop();
        astack.print();
        astack.push('n');
        astack.print();
        System.out.println(astack.peek());
        System.out.println("=LinkedStack=");
        LinkedStack<Character> lstack = new LinkedStack<>();
        for (int i = 0; i < 30; i++) {
            lstack.push((char) (i + 35));
        }
        lstack.print();
        lstack.pop();
        lstack.print();
        lstack.push('n');
        lstack.print();
        System.out.println(lstack.peek());
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
