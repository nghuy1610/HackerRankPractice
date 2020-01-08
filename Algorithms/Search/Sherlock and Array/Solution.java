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

public class Solution {

    // Complete the balancedSums function below.
    // static String balancedSums(List<Integer> arr) {
    //     int len = arr.size();
    //     int left = -1, right = len;
    //     int sumL = 0, sumR = 0;
    //     while (right - left != 2) {
    //         if (sumL == sumR) {
    //             sumL = 0; sumR = 0;
    //             if (arr.get(left+1) < arr.get(right-1)) {
    //                 left++;
    //                 sumL += arr.get(left);
    //             } else {
    //                 right--;
    //                 sumR += arr.get(right);
    //             }
    //         } else if (sumL > sumR) {
    //             sumL -= sumR; sumR = 0;
    //             right--; sumR += arr.get(right);
    //         } else {
    //             sumR -= sumL; sumL = 0;
    //             left++; sumL += arr.get(left);
    //         }
    //     }
    //     if (sumL == sumR) {
    //         return "YES";
    //     } else {
    //         return "NO";
    //     }
    // }

    static String balancedSums(List<Integer> arr) {
        long sum = 0;
        for (Integer i : arr) {
            sum += i;
        }
        int sumL = 0;
        for (Integer i : arr) {
            if (sum - i - 2 * sumL == 0) {
                return "YES";
            }
            sumL += i;
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
