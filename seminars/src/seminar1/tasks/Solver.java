package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import collections.ArrayStack;

/**
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * ( 4 * 5 ) ) ) = 101
 * ( 1 + ( 5 * 20 ) ) = 101
 * ( 1 + 100 ) = 101
 *
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {

    private static final String QUIT = "q";

    private static final String LEFT_PAREN   = "(";
    private static final String RIGHT_PAREN  = ")";
    private static final String PLUS         = "+";
    private static final String MINUS        = "-";
    private static final String TIMES        = "*";
    private static final String DIVISION     = "/";

    private static ArrayStack<String>   stack;
    private static String               output;

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                String postfixExpression = infixToPostfix(sequence.split(" "));
                String[] postfixSequence = postfixExpression.split(" ");
                System.out.println(evaluate(postfixSequence));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String infixToPostfix(String[] values) {
        stack = new ArrayStack<>();
        output = "";
        for (String val : values) {
            switch (val) {
            case PLUS:
            case MINUS:
                gotOper(val, 1);
                break;
            case TIMES:
            case DIVISION:
                gotOper(val, 2);
                break;
            case LEFT_PAREN:
                stack.push(val);
                break;
            case RIGHT_PAREN:
                gotParen();
                break;
            default:
                output += val + " ";
                break;
            }
        }
        while (!stack.isEmpty()) {
            output += stack.pop() + " ";
        }
        return output;
    }

    private static void gotOper(String opThis, int prec1) {
        while (!stack.isEmpty()) {
            String opTop = stack.pop();
            if (opTop.equals("(")) {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop.equals(PLUS) || opTop.equals(MINUS))
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                }
                else output += opTop + " ";
            }
        }
        stack.push(opThis);
    }

    private static void gotParen() {
        while (!stack.isEmpty()) {
            String chx = stack.pop();
            if (chx.equals("("))
                break;
            else output += chx + " ";
        }
    }

    private static double evaluate(String[] values) {
        stack = new ArrayStack<>();

        for (String tmp : values) {
            if (tmp.matches("[0-9]*"))
                stack.push(tmp);
            else
            if (tmp.matches("[*-/+]")) {
                switch (tmp) {
                    case TIMES: {
                        int firstOperand = Integer.parseInt(stack.pop());
                        int secondOperand = Integer.parseInt(stack.pop());
                        int result = secondOperand * firstOperand;
                        stack.push("" + result);
                        break;
                    }
                    case MINUS: {
                        int firstOperand = Integer.parseInt(stack.pop());
                        int secondOperand = Integer.parseInt(stack.pop());
                        int result = secondOperand - firstOperand;
                        stack.push("" + result);
                        break;
                    }
                    case DIVISION: {
                        int firstOperand = Integer.parseInt(stack.pop());
                        int secondOperand = Integer.parseInt(stack.pop());
                        int result = secondOperand / firstOperand;
                        stack.push("" + result);
                        break;
                    }
                    case PLUS: {
                        int firstOperand = Integer.parseInt(stack.pop());
                        int secondOperand = Integer.parseInt(stack.pop());
                        int result = secondOperand + firstOperand;
                        stack.push("" + result);
                        break;
                    }
                }
            }
        }
        return Double.valueOf(stack.pop());
    }
}
