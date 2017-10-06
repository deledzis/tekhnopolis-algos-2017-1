import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer, Integer> list = new TreeMap<>();

        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            int key = in.nextInt();
            list.put(key, 1 + (list.getOrDefault(key, 0)));
        }

        if (list.get(list.firstKey()) > 1)
            System.out.println(list.firstKey() + " " + list.firstKey());
        else
            System.out.print(list.firstKey() + " " + list.higherKey(list.firstKey()));
    }
}