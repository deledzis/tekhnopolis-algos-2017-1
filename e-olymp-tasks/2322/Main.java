import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        byte[] checks = new byte[n];

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);

            for (int j = 0; j < n; j++) {
                int num = lineScanner.nextInt();
                if (checks[j] == 0)
                    checks[j] = (byte) (num == x ? 1: 0);
            }
        }

        for (int i = 0; i < n; i++) {
            if (checks[i] == 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}