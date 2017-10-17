import java.util.Scanner;

/**
 * Верёвочки
 * С утра шел дождь, и ничего не предвещало беды. Но к обеду выглянуло солнце, и в лагерь заглянула СЭС. Пройдя по всем домикам и корпусам, СЭС вынесла следующий вердикт: бельевые верёвки в жилых
 * домиках не удовлетворяют нормам СЭС. Как выяснилось, в каждом домике должно быть ровно по одной бельевой верёвке, и все верёвки должны иметь одинаковую длину. В лагере имеется N бельевых верёвок и
 * K домиков. Чтобы лагерь не закрыли, требуется так нарезать данные верёвки, чтобы среди полученных верёвочек было K одинаковой длины. Размер штрафа обратно пропорционален длине бельевых верёвок,
 * которые будут развешены в домиках. Поэтому начальство лагеря стремится максимизировать длину этих верёвочек.
 *
 * Входные данные
 * В первой строке заданы два числа - N (1 ≤ N≤ 10001) и K (1≤ K≤ 10001). Далее в каждой из последующихN строк записано по одному числу - длине очередной бельевой верёвки. Длина верёвки задана в
 * сантиметрах. Все длины лежат в интервале от 1 сантиметра до 100 километров включительно.
 *
 * Выходные данные
 * В выходной файл следует вывести одно целое число - максимльную длину верёвочек, удовлетворяющих условию, в сантиметрах. В случае, если лагерь закроют, выведите 0.
 */
public class Task3967 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfRopes = in.nextInt();
        int numberOfHouses = in.nextInt();
        long[] ropes = new long[numberOfRopes];
        
        long totalLengthOfTheRopes = 0;
        for (int i = 0; i < numberOfRopes; i++) {
            ropes[i] = in.nextLong();
            totalLengthOfTheRopes += ropes[i];
        }

        System.out.println(binarySearch(ropes, totalLengthOfTheRopes, numberOfHouses));
    }
    
    private static long binarySearch(long[] ropes, long totalLengthOfTheRopes, long numberOfHouses) {
        long minLength = 0;
        long maxLength = totalLengthOfTheRopes / numberOfHouses + 1;
        long middleLength = minLength + (maxLength - minLength) / 2;

        while (minLength < middleLength) {
            int pieces = 0;
            for (long rope : ropes) {
                pieces += rope / middleLength;
            }

            if (pieces < numberOfHouses)
                maxLength = middleLength;
            else
                minLength = middleLength;

            middleLength = minLength + (maxLength - minLength) / 2;
        }
        return middleLength;
    }
}