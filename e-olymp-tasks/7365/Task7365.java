import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

/**
 * Молоко и пирожок
 * Ученикам первого класса дополнительно дают стакан молока и пирожок, если вес первоклассника менее 30 кг. В первых классах школы учится n учеников. Стакан молока имеет емкость 200 мл, а упаковки молока –
 * 0,9 л. Определить количество дополнительных пакетов молока и пирожков, необходимых каждый день.
 *
 * Входные данные
 * В первой строке задано целое число n (0 < n ≤ 100). В следующей строке идут n положительных действительных чисел – массы первоклассников.
 *
 * Выходные данные
 * В одной строе вывести два целых числа - количество дополнительных пакетов молока и пирожков, необходимых каждый день.
 */
public class Task7365 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(new Locale("US"));
        PrintWriter out = new PrintWriter(System.out);

        int additionalFoodCount = 0;

        in.nextLine();
        String allWeight = in.nextLine();
        for (String strWeight :
                allWeight.split(" ")) {
            double weight = Double.parseDouble(strWeight);

            if (weight < 30.0) {
                additionalFoodCount++;
            }
        }

        out.println((int) Math.ceil((double) (additionalFoodCount * 200) / 900) + " " + additionalFoodCount);

        out.flush();
    }
}