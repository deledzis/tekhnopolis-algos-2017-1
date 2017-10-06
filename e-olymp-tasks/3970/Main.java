import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
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