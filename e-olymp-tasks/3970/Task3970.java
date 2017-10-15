import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Мутанты
 * Уже долгое время в Институте Искусств, Мутантов и Информационных Технологий разводят милых разноцветных зверюшек. Для удобства каждый цвет обозначен своим номером, всего цветов не более 109. В один из
 * прекрасных дней в питомнике случилось чудо: все зверюшки выстроились в ряд в порядке возрастания цветов. Пользуясь случаем, лаборанты решили посчитать, сколько зверюшек разных цветов живёт в питомнике,
 * и, по закону жанра, попросили вас написать программу, которая поможет им в решении этой нелёгкой задачи.
 *
 * Входные данные
 * В первой строке входного файла содержится единственное число N (0 ≤ N ≤ 105) - количество зверюшек в Институте. В следующей строке находится N упорядоченных по неубыванию неотрицательных целых чисел, не
 * превосходящих 109 и разделённых пробелами - их цвета. В третьей строке файла записано число M (1 ≤ M≤ 100000) - количество запросов вашей программе, в следующей строке через пробел записаны M целых
 * неотрицательных чисел (не превышающих 109+1).
 *
 * Выходные данные
 * Выходной файл должен содержать M строчек. Для каждого запроса выведите число зверюшек заданного цвета в питомнике.
 */
public class Task3970 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(new Locale("US"));
        PrintWriter out = new PrintWriter(System.out);

        HashMap<Integer, Integer> mutants = new HashMap<>();

        in.nextLine();
        String firstLine = in.nextLine();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(firstLine);
        while (m.find()) {
            int num = Integer.parseInt(m.group());
            if (mutants.containsKey(num)) {
                mutants.replace(num, mutants.get(num) + 1);
            } else {
                mutants.put(num, 1);
            }
        }

        in.nextLine();
        String secondLine = in.nextLine();
        m = p.matcher(secondLine);
        while (m.find()) {
            int num = Integer.parseInt(m.group());
            if (mutants.containsKey(num))
                out.println(mutants.get(num));
            else
                out.println(0);
        }

        out.flush();
    }
}