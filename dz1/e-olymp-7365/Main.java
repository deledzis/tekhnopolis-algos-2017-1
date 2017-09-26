import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
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