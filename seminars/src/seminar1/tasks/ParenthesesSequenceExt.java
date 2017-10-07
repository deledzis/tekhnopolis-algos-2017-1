package seminar1.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import seminar1.implementations.MyStack;

/**
 * 1. пустая строка — правильная скобочная последовательность;
 * 2. правильная скобочная последовательность,
 *      взятая в скобки одного типа — правильная скобочная последовательность;
 * 3. правильная скобочная последовательность,
 *      к которой приписана слева или справа правильная скобочная последовательность
 *      — тоже правильная скобочная последовательность.
 */
public class ParenthesesSequenceExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    // sequence = "()()" | "(({}[]))[[[" | "{}" | ...
    private static boolean isBalanced(String sequence) {
        MyStack<Character> stack = new MyStack<>(sequence.length());
        char c;
        for (int i = 0; i < sequence.length(); i++) {
            c = sequence.charAt(i);
            if (c == LEFT_PAREN || c == LEFT_BRACE || c == LEFT_BRACKET) {
                stack.push(c);
            }
            else if (c == RIGHT_PAREN) {
                if (stack.isEmpty() || (char) stack.pop() != LEFT_PAREN) {
                    return false;
                }
            }
            else if (c == RIGHT_BRACE) {
                if (stack.isEmpty() || (char) stack.pop() != LEFT_BRACE) {
                    return false;
                }
            }
            else if (c == RIGHT_BRACKET) {
                if (stack.isEmpty() || (char) stack.pop() != LEFT_BRACKET) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(isBalanced(sequence) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
