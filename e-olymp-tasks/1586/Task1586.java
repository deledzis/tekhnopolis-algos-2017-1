import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Постфиксная запись
 * В постфиксной записи (или обратной польской записи) операция записывается после двух операндов. Например, сумма двух чисел A и B записывается как A B +. Запись B C + D * обозначает привычое нам
 * (B + C) * D, а запись A B C + D * + означает A + (B + C) * D. Достоинство постфиксной записи в том, что она не требует скобок и дополнительных соглашений о приоритете операторов для своего чтения.
 *
 * Входные данные
 * В единственной строке записано выражение в постфиксной записи, содержащее однозначные числа и операции +, -, *. Строка содержит не более 100 чисел и операций.
 *
 * Выходные данные
 * Необходимо вывести значение записанного выражения. Гарантируется, что результат выражения, а также результаты всех промежуточных вычислений по модулю меньше 2^31.
 *
 */
public class Task1586 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] postfixExpressionGiven = in.nextLine().split(" ");
        ArrayStack<String> stack = new ArrayStack<>();

        for (String tmp : postfixExpressionGiven) {
            if (tmp.matches("[0-9]*"))
                stack.push(tmp);
            else
            if (tmp.matches("[*-/+]")) {
                switch (tmp) {
                case "*": {
                    int firstOperand = Integer.parseInt(stack.pop());
                    int secondOperand = Integer.parseInt(stack.pop());
                    int result = secondOperand * firstOperand;
                    stack.push("" + result);
                    break;
                }
                case "-": {
                    int firstOperand = Integer.parseInt(stack.pop());
                    int secondOperand = Integer.parseInt(stack.pop());
                    int result = secondOperand - firstOperand;
                    stack.push("" + result);
                    break;
                }
                case "/": {
                    int firstOperand = Integer.parseInt(stack.pop());
                    int secondOperand = Integer.parseInt(stack.pop());
                    int result = secondOperand / firstOperand;
                    stack.push("" + result);
                    break;
                }
                case "+": {
                    int firstOperand = Integer.parseInt(stack.pop());
                    int secondOperand = Integer.parseInt(stack.pop());
                    int result = secondOperand + firstOperand;
                    stack.push("" + result);
                    break;
                }
                }
            }
        }
        System.out.println(stack.pop());
    }
}

class ArrayStack<Item> {

    private static final int DEFAULT_CAPACITY = 100;

    private Item[]  elementData;
    private int     size;

    @SuppressWarnings("unchecked")
    ArrayStack() {
        this.elementData    = (Item[]) new Object[DEFAULT_CAPACITY];
        size                = 0;
    }

    public void push(Item item) {
        elementData[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Array is empty");

        Item item = elementData[--size];
        elementData[size] = null;
        return item;
    }

    private boolean isFull() {
        return size() == elementData.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}