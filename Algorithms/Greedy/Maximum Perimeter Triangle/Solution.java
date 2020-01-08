import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        int len = sticks.length;
        int s1 = -1, s2 = -1, s3 = -1;
        outloop:
        for (int i = len - 1; i > 1; i--) {
            for (int j = i - 1; j > 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (sticks[k] + sticks[j] > sticks[i] && sticks[i] - sticks[j] < sticks[k]) {
                        s1 = sticks[i]; s2 = sticks[j]; s3 = sticks[k];
                        break outloop;
                    }
                }
            }
        }
        if (s1 == -1) {
            return new int[] {-1};
        } else {
            return new int[] {s3, s2, s1};
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
