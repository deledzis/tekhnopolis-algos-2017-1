package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import collections.ArrayStack;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN   = '(';
    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';

    private static ArrayStack<String>   stack;
    private static String               output = "";

    private static double evaluate(String[] values) {
        stack = new ArrayStack<>();

        //stackSize = values.length;
        // Double.valueOf(values[i])
        return 0D;
    }

    public static String infixToPostfix(String[] values) {
        for (int i = 0; i < values.length; i++) {
            String val = values[i];
            System.out.println(val);
            switch (val) {
                case "+":
                case "-":
                    gotOper(val, 1);
                    break;
                case "*":
                case "/":
                    gotOper(val, 2);
                    break;
                case "(":
                    stack.push(val);
                    break;
                case ")":
                    gotParen();
                    break;
                default:
                    output += val;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            output = output + stack.pop();
        }
        System.out.println(output);
        return output;
    }

    public static void gotOper(String opThis, int prec1) {
        while (!stack.isEmpty()) {
            String opTop = stack.pop();
            if (opTop.equals("(")) {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop.equals("+") || opTop.equals("-"))
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                }
                else output = output + opTop;
            }
        }
        stack.push(opThis);
    }

    public static void gotParen() {
        while (!stack.isEmpty()) {
            String chx = stack.pop();
            if (chx.equals("("))
                break;
            else output += chx;
        }
    }

    public boolean isOperator(String value) {
        return value.length() == 1 &&
                (value.charAt(0) == LEFT_PAREN || value.charAt(0) == RIGHT_PAREN ||
                 value.charAt(0) == PLUS || value.charAt(0) == MINUS ||
                 value.charAt(0) == TIMES || value.charAt(0) == DIVISION);
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            stack = new ArrayStack<>();
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(infixToPostfix(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
