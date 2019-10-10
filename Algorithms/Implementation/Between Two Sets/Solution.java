import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

   public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
            int c = 0;
            int n = 1;
            // 2, 3, 5, 7
            int[] ar = new int[] {0, 0, 0, 0};
            int[] k = new int[] {2, 3, 5, 7};
            for (Integer na : a) {
                for (int i = 0; i < k.length; i++) {
                    int co = 0;
                    while (na % k[i] == 0) {
                        na /= k[i];
                        co++;
                    }
                    if (co > ar[i]) {
                        ar[i] = co;
                    }
                }
            }
            for (int j = 0; j < ar.length; j++) {
                while (ar[j] > 0) {
                    n *= k[j];
                    ar[j]--;
                }
            }
            outloop:
            for (int m = n; m <= b.get(0); m += n) {
                for (Integer nb : b) {
                    if ((nb % m) != 0) {
                        continue outloop;
                    }
                }
                c++;
            }
            return c;
        }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
