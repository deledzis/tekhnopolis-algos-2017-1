import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Быстрая сортировка
 *
 * Отсортируйте заданную последовательность.
 *
 * Входные данные
 * В одной строке содержится последовательность, содержащая не более 100000 целых чисел.
 *
 * Выходные данные
 * В одной строке вывести последовательность чисел в неубывающем порядке. Числа разделять между собой одним пробелом.
 */
public class Task4848QSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        ArrayList<Long> arr = new ArrayList<>();

        String line = in.nextLine();
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(line);
        while (m.find()) {
            arr.add(Long.parseLong(m.group()));
        }

        sort(arr, 0, arr.size() - 1);

        for (Long a : arr) {
            System.out.print(a + " ");
        }

        out.flush();
    }

    private static void sort(ArrayList<Long> array, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        int cur = i - (i - j) / 2;

        while (i < j) {
            while (i < cur && (array.get(i) <= array.get(cur))) {
                i++;
            }
            while (j > cur && (array.get(cur) <= array.get(j))) {
                j--;
            }
            if (i < j) {
                Long temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                if (i == cur) {
                    cur = j;
                }
                else if (j == cur) {
                    cur = i;
                }
            }
        }
        sort(array, start, cur);
        sort(array, cur + 1, end);
    }
}