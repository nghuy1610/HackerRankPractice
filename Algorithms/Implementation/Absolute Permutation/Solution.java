import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int[] rs  = new int[n];
        if (k == 0) {
            for (int i = 0; i < n; i++) {rs[i] = i+1;}
        } else if (n % k != 0 || (n / k) % 2 != 0) {return new int[]{-1};}
        else {
            int count = 0;
            int temp = k;
            for (int j = 0; j < n; j++) {
                rs[j] = j + temp + 1;
                count++;
                if (count == k) {
                    count = 0;
                    temp = -temp;
                }
            }
        }
        return rs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
