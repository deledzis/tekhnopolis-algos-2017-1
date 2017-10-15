import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task6125 {
    private FastScanner in;
    private PrintWriter out;

    private void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void solve() throws IOException {
        Queue queue = new Queue();
        String command = in.next();

        while (true) {
            switch (command) {
            case "exit":
                out.println(queue.exit());
                return;
            case "clear":
                out.println(queue.clear());
                break;
            case "size":
                out.println(queue.size());
                break;
            case "front":
                out.println(queue.front());
                break;
            case "pop":
                out.println(queue.pop());
                break;
            default:
                queue.push(in.next());
                out.println("ok");
                break;
            }
            command = in.next();
        }
    }

    public static void main(String[] args) {
        new Task6125().run();
    }
}

class FastScanner {
    private BufferedReader br;
    private StringTokenizer st;

    FastScanner(File f) {
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
}

class Queue {
    private Object[]    storage;
    private int         head;
    private int         tail;

    Queue () {
        head = tail = 0;
        storage = new Object[100000];
    }

    void push(Object item) {
        storage[head] = item;
        head++;
    }

    Object pop() {
        Object item = storage[tail];
        tail++;
        return item;
    }

    Object front() {
        return storage[tail];
    }

    int size() {
        return head - tail;
    }

    String  clear() {
        head = tail = 0;
        return "ok";
    }

    String exit() {
        return "bye";
    }
}