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
public class Task4848HSort {
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

        sort(arr);

        for (Long a :
                arr) {
            System.out.print(a + " ");
        }

        // -11 1 9 21 24 -10 28 9 9 5 -1 -6 -7 7 -16
        out.flush();
    }

    //Сортировка кучей
    private static void sort(ArrayList<Long> a) {
        int N = a.size();
        //Создаём из массива сортирующее дерево
        //Максимальный элемент окажется в корне.
        for (int k = N / 2; k > 0; k--) {
            //System.out.print("first: ");
            downHeap(a, k, N);
        }

        //Избавляемся от максимумов
        //и перетряхиваем сортирующее дерево
        do {
            //Меняем максимум с последним элементом...
            long T = a.get(0);
            a.set(0, a.get(N - 1));
            a.set(N - 1, T);
            //... и перестравиваем сортирующее дерево
            //для неотсортированной части массива
            N = N - 1;
            //System.out.print("second: ");
            downHeap(a, 1, N);
        } while (N > 1); //До последнего элемента
    }

    //Просматриваем ветку и в её корень перемещаем наибольший узел
    private static void downHeap(ArrayList<Long> a, int k, int N) {
        //В корне поддерева
        //запоминаем родителя
        long T = a.get(k - 1);

        //Смотрим потомков в пределах ветки
        while (k <= N / 2) {
            int j = k + k;//Левый потомок

            //Если есть правый потомок,
            //то сравниваем его с левым
            //и из них выбираем наибольший
            if ((j < N) && (a.get(j - 1) < a.get(j)))
                j++;

            //Если родитель больше (или равен) наибольшего потомка...
            if (T >= a.get(j - 1)) {
                //... то значит всё в порядке в этой ветке
                break;
            } else { //Если родитель меньше наибольшего потомка...
                //... то потомок становится на место родителя
                a.set(k - 1, a.get(j - 1));
                k = j;
            }
        }
        //Родитель в итоге меняется местами с наибольшим из потомков
        //(или остаётся на своём месте, если все потомки меньше его)
        a.set(k - 1, T);
        //for (Long c :
        //        a) {
        //    System.out.print(c + " ");
        //}
        //System.out.println();
    }
}