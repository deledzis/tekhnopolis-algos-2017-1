import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Мутанты
 * Уже долгое время в Институте Искусств, Мутантов и Информационных Технологий разводят милых разноцветных зверюшек. Для удобства каждый цвет обозначен своим номером, всего цветов не более 10^9. В
 * один из прекрасных дней в питомнике случилось чудо: все зверюшки выстроились в ряд в порядке возрастания цветов. Пользуясь случаем, лаборанты решили посчитать, сколько зверюшек разных цветов живёт
 * в питомнике, и, по закону жанра, попросили вас написать программу, которая поможет им в решении этой нелёгкой задачи.
 *
 * Входные данные
 * В первой строке входного файла содержится единственное число N (0 ≤ N ≤ 10^5) - количество зверюшек в Институте. В следующей строке находится N упорядоченных по неубыванию неотрицательных целых
 * чисел, не превосходящих 10^9 и разделённых пробелами - их цвета. В третьей строке файла записано число M (1 ≤ M≤ 100000) - количество запросов вашей программе, в следующей строке через пробел
 * записаны M целых неотрицательных чисел (не превышающих 10^9 + 1).
 *
 * Выходные данные
 * Выходной файл должен содержать M строчек. Для каждого запроса выведите число зверюшек заданного цвета в питомнике.
 */
public class Task3970 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int size = Integer.parseInt(in.nextLine());
        Mutant[] mutants = new Mutant[size];
        String line = in.nextLine();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);

        int i = -1;
        int tmp;
        int previous = -1;
        while (m.find()) {
            tmp = Integer.parseInt(m.group());
            if (tmp != previous) {
                mutants[++i] = new Mutant(tmp, 1);
                previous = tmp;
            }
            else {
                mutants[i].count++;
            }
        }
        mutants = Arrays.copyOf(mutants, ++i);

        in.nextLine();
        line = in.nextLine();
        m = p.matcher(line);
        int idx;
        while (m.find()) {
            idx = checkMutant(mutants, Integer.parseInt(m.group()));
            System.out.println(idx > -1 ? mutants[idx].count : 0);
        }

        out.flush();
    }

    static class Mutant {
        int color;
        int count;

        Mutant(int color, int count) {
            this.color = color;
            this.count = count;
        }
    }

    private static int checkMutant(Mutant[] array, int number) {
        int low = 0, high = array.length, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (number == array[mid].color) {
                return mid;
            }
            if (number < array[mid].color) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}