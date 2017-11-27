import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SeminarTest {

    private static final String QUIT = "q";
    private static       byte[] seats;

    public static void main(String[] args) {
        seats = new byte[25];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = 0;
        }

        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            System.out.print("Укажите место: ");
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println("seq " + sequence);
                seats[Integer.parseInt(sequence)] = 1;
                int counter = 0;
                int tmpPlace = findPlace();
                while (tmpPlace != -1) {
                    seats[tmpPlace] = 1;
                    counter++;
                    tmpPlace = findPlace();
                    System.out.println(counter);
                }
                System.out.println("поместится " + counter + " человек");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findPlace() {
        int place = -1;
        int i = 0, startIndex = 0, endIndex = 0, maxFreeSequence = 0;
        for (byte seat : seats) {
            System.out.println(i++ + " " + Arrays.toString(seats));
            if (seat == 1) {
                maxFreeSequence = endIndex - startIndex > maxFreeSequence ? endIndex - startIndex : maxFreeSequence;
                startIndex = endIndex + 1;
            } else {
                endIndex++;
            }
        }
        if ((startIndex != 0 && seats[startIndex - 1] == 1)
                && (endIndex != seats.length - 1 && seats[endIndex + 1] == 1)) {
            place = (startIndex + endIndex) / 2;
        }
        else if (startIndex != 0 && seats[startIndex - 1] == 1
                && endIndex == seats.length - 1) {
            place = seats.length - 1;
        }
        else if (endIndex != seats.length - 1 && seats[endIndex + 1] == 1
                && startIndex == 0) {
            place = 0;
        }
        return place;
    }
}
