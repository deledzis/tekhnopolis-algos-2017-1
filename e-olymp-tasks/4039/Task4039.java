import collections.ArrayPriorityQueue;

/**
 * Хипуй!
 * В этой задаче вам необходимо организовать структуру данных Heap для хранения целых чисел, над которой определены следующие операции:
 * Insert(X) - добавить в HeapX;
 * Extract - достать из Heap наибольшее число (удалив его при этом).
 *
 * Входные данные
 * Во входном файле записано количество команд N (1 ≤ N≤ 100000), потом последовательность из N команд, каждая в своей строке.
 * Каждая команда имеет такой формат: "0 <число>" или "1", что означает соответственно операции Insert (<число>) и Extract. Добавляемые числа находятся в интервале от 1 до 10^7 включительно.
 * Гарантируется, что при выполнении команды Extract в структуре находится по крайней мере 1 элемент.
 *
 * Выходные данные
 * В выходной файл для каждой команды извлечения необходимо вывести число, полученное при выполнении команды Extract.
 */
public class Task4039 {
    public static void main(String[] args) {
        ArrayPriorityQueue<Integer> arrayPriorityQueue = new ArrayPriorityQueue<>(Comparable::compareTo);

        arrayPriorityQueue.add(69);
        arrayPriorityQueue.add(65);
        arrayPriorityQueue.add(83);
        arrayPriorityQueue.add(89);
        arrayPriorityQueue.add(81);
        arrayPriorityQueue.add(85);
        arrayPriorityQueue.add(69);
        arrayPriorityQueue.add(83);
        arrayPriorityQueue.add(84);
        arrayPriorityQueue.add(73);
        arrayPriorityQueue.add(79);
        arrayPriorityQueue.add(78);

        arrayPriorityQueue.print();

        //print values
        while (!arrayPriorityQueue.isEmpty()) {
            System.out.print("min: " + arrayPriorityQueue.extractMin() + " -> ");
            arrayPriorityQueue.print();
        }

    }
}