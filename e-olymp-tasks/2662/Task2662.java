import java.io.PrintWriter;
import java.util.*;

/**
 * Метод минимума
 *
 * Массив сортируется методом выбора по возрастанию. Сколько раз меняет свое место первый по порядку элемент?
 *
 * Входные данные
 * Первая строка содержит количество элементов в массиве n (1 ≤ n ≤ 1000). Во второй строке задан сам массив.
 * Гарантируется, что все элементы массива различны и не превышают по модулю 109.
 *
 * Выходные данные
 * Вывести количество перемещений первого элемента.
 */
public class Task2662 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long[] arr = new long[in.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(selectionSort(arr));
        out.flush();
    }

    private static int selectionSort(long[] arr) {
        int swaps = 0;
        int firstElIndex = 0;

        for (int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = (i + 1); j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (firstElIndex == minIndex && minIndex != i) {
                swaps++;
                firstElIndex = i;
            }
            else if (firstElIndex == i && i != minIndex) {
                swaps++;
                firstElIndex = minIndex;
            }
            long temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return swaps;
    }
}