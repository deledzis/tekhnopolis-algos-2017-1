import java.io.PrintWriter;
import java.util.*;

/**
 * Сортировка пузырьком - 2
 *
 * Определите, сколько обменов сделает алгоритм пузырьковой сортировки по возрастанию для данного массива.
 *
 * Входные данные
 * В первой строке дано число N (1 ≤ N≤ 1000) - количество элеменов в массиве. Во второй строке - сам массив.
 * Гарантируется, что все элементы массива различны и не превышают по модулю 109.
 *
 * Выходные данные
 * Выведите одно число - количество обменов пузырьковой сортировки.
 */
public class Task4741 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int size = in.nextInt();
        long[] arr = new long[size];

        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }

        out.println(bubbleSort(arr, size));
        out.flush();
    }

    private static int bubbleSort(long[] arr, int size) {
        long temp;
        int swaps = 0;

        for(int i = 0; i < size; i++){
            for(int j = 1; j < (size - i); j++){
                if(arr[j - 1] > arr[ j ]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}