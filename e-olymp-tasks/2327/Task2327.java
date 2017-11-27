import java.util.Scanner;

/**
 * Сортировка подсчетом
 *
 * Воспользуйтесь магической силой сортировки подсчётом и отсортируйте n чисел из диапазона [0; 100000].
 *
 * Входные данные
 * Первая строка содержит число n (1 ≤ n ≤ 106). Далее идут n чисел, которые следует отсортировать.
 *
 * Выходные данные
 * Выведите n отсортированных чисел.
 */
public class Task2327 {
    private static final int MAX_VALUE = 100001;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//11 1 9 21 24 10 28 9 9 5 1 6 7 7 16 52 47 92 0 0 48 35 35 99 100 88 2 0 9 9 448 220 6 99 1100 0 48698 100000 100000 99999 5 5 7 412 99999 100000
        int size = in.nextInt();
        int number[] = new int[size];

        for (int i = 0; i < size; i++) {
            number[i] = in.nextInt();
        }

        int[] res = countingSort(number);

        for (int a : res) {
            System.out.print(a + " ");
        }
    }

    private static int[] countingSort(int[] arr) {
        int[] res = new int[arr.length];
        int k;

        for (int i = 0; i < arr.length; i++) {
            for (int j = k = 0; j < arr.length; j++) {
                if (arr[j] < arr[i] || (arr[i] == arr[j] && i < j)) {
                    k++;
                }
            }
            res[k] = arr[i];
        }

        return res;
    }
}