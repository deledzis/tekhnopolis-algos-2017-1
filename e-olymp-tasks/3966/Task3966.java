import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ярый коллекционер бабочек
 * Как известно, Андрй Сергеевич - ярый коллекционер бабочек. Он имеет огромную коллекцию, экспонаты которой собраны со всего мира. Будем считать, что в мире существует 2000000000 видов бабочек.
 * Чтобы не запутаться, Андрей Сергеевич присвоил каждому виду уникальный номер. Нумерация бабочек всегда начинается с единицы.
 * Теперь он хочет знать, есть ли бабочка с видом K в его коллекции, или же её придётся добывать, затрачивая уйму сил и денег.
 *
 * Входные данные
 * В первой строке входного файла содержится единственное число N (1 ≤ N≤ 100000) - количество видов бабочек в коллекции Андрея Сергеевича.
 * В следующей строке через пробел находятся N упорядоченных по возрастанию чисел - номера видов бабочек в коллекции.
 * Все виды бабочек в коллекции имеют различные номера.
 * В третьей строке файла записано число M (1≤ M≤ 100000) - количество видов бабочек, про которых Андрей Сергеевич хочет узнать, есть ли они у него в коллекции или же нет. В последней строке входного файла содержатся через пробел M чисел - номера видов бабочек, наличие которых необходимо проверить.
 *
 * Выходные данные
 * Выходной файл должен содержать M строчек. Для каждого запроса выведите "YES", если бабочка с данным номером содержится в коллекции, и "NO" - в противном случае.
 */
public class Task3966 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int size = Integer.parseInt(in.nextLine());
        int[] collection = new int[size];
        String line = in.nextLine();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);
        int i = 0;
        while (m.find()) {
            collection[i++] = Integer.parseInt(m.group());
        }

        in.nextLine();
        line = in.nextLine();
        m = p.matcher(line);
        while (m.find()) {
            out.println(checkButterfly(collection, Integer.parseInt(m.group())) > -1 ? "YES" : "NO");
        }

        out.flush();
    }

    private static int checkButterfly(int[] array, int number) {
        int i = -1;
        int low = 0, high = array.length, mid;
        while (low < high) {
            mid = (low + high) >>> 1;
            if (number == array[mid]) {
                i = mid;
                break;
            } else {
                if (number < array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return i;
    }
}