import java.util.Scanner;

/**
 * Куча ли?
 * Структуру данных Heap можно реализовать на основе массива.
 * Для этого должно выполняться основное свойство Heapa, которое заключается в следующем. Для каждого i (1 ≤ i ≤ n) выполняются следующие условия:
 * Если 2i ≤ n, то ai ≤ a2i
 * Если 2i + 1 ≤ n, то ai ≤ a2i+1
 * Дан массив целых чисел. Определите является ли он Heapом.
 *
 * Входные данные
 * Первая строка содержит целое число n (1 ≤ n ≤ 10^5). Вторая строка содержит n целых чисел, не превосходящих по модулю 2·10^9.
 *
 * Выходные данные
 * Выведите "YES", если массив является Heapом и "NO" в противном случае.
 */
public class Task3737 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        long[] numbers = new long[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = in.nextLong();
        }

        System.out.println(isHeap(numbers)? "YES" : "NO");
    }

    private static boolean isHeap(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if  (
                    (2 * i + 1 < arr.length && arr[i] > arr[2 * i + 1])
                    ||
                    (2 * i + 2 < arr.length && arr[i] > arr[2 * i + 2])
                )
            {
                return false;
            }
        }
        return true;
    }
}