import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = in.nextInt();

        for (int i = 0; i < num; i++) out.println(in.nextInt() + in.nextInt());

        out.flush();
    }
}