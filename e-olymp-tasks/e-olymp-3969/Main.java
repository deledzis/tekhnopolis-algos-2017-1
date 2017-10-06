import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static long binarySearch(long width, long height, long number) {
        long left = 0;
        long right = Math.max(width, height) * number;

        while (left < right - 1) {
            long t = (left + right) / 2;
            long sq = (t / width) * (t / height);

            if (sq >= number) {
                right = t;
            } else {
                left = t;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long width = in.nextInt();
        long height = in.nextInt();
        long number = in.nextInt();

        out.println(binarySearch(width, height, number));
        out.flush();
    }
}