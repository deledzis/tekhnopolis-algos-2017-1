import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = in.nextInt();

        while(in.hasNextInt()) result = gcd(result, in.nextInt());
        System.out.println(result);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}