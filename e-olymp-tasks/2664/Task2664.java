import java.io.PrintWriter;
import java.util.*;

/**
 * Библиотечный метод
 *
 * Продемонстрируйте работу метода сортировки простыми вставками по возрастанию.
 * Для этого выведите состояние данного массива после каждой вставки на отдельных строках.
 * Если массив упорядочен изначально, то следует не выводить ничего.
 *
 * Входные данные
 * В первой строке дано число N (1 ≤ N ≤ 100) - количество элементов в массиве.
 * Во второй строке задан сам массив: последовательность натуральных чисел, не превышающих 10^9.
 *
 * Выходные данные
 * В выходной файл выведите строки (по количеству вставок) по N чисел каждая.
 */
public class Task2664 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long[] arr = new long[in.nextInt()];
        Map<Integer, ArrayList<String>> map = new HashMap<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        map = insertionSort(arr, map);

        for (Integer key : map.keySet()) {
            ArrayList<String> tempList = map.get(key);
            if (tempList != null) {
                for (String value : tempList) {
                    System.out.println(key + " | " + value);
                }
            }
        }
        // -11 1 9 21 24 -10 28 9 9 5 -1 -6 -7 7 -16
        out.flush();
    }

    private static Map<Integer, ArrayList<String>> insertionSort(long[] arr, Map<Integer, ArrayList<String>> map) {
        for (int i = 1; i < arr.length; i++) {
            int swaps = 0;
            for(int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j - 1]) {
                    long temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swaps++;
                }
            }
            if (swaps > 0) {
                StringBuilder line = new StringBuilder();
                for (long x : arr) {
                    line.append(x).append(" ");
                }
                map = mapItems(map, swaps, line.toString());
            }
        }
        return map;
    }

    private static Map<Integer, ArrayList<String>> mapItems(Map<Integer, ArrayList<String>> map,
                                                            Integer key, String value) {
        ArrayList tempList;
        if (map.containsKey(key)) {
            tempList = map.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);
        } else {
            tempList = new ArrayList();
            tempList.add(value);
        }
        map.put(key,tempList);

        return map;
    }
}