import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(new Locale("US"));
        PrintWriter out = new PrintWriter(System.out);

        HashSet<Integer> isInCollection = new HashSet<>();

        in.nextLine();
        String firstLine = in.nextLine();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(firstLine);
        while (m.find()) {
            isInCollection.add(Integer.parseInt(m.group()));
        }

        in.nextLine();
        String secondLine = in.nextLine();
        m = p.matcher(secondLine);
        while (m.find()) {
            if (isInCollection.contains(Integer.parseInt(m.group())))
                out.println("YES");
            else
                out.println("NO");
        }

        out.flush();
    }
}