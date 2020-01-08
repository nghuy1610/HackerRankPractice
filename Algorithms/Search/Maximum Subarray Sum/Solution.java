import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumSum function below.
 static long maximumSum(long[] a, long m) {
        int len = a.length;
        long[] prefixSum = new long[len];
        long current = 0;
        for (int i = 0; i < len; i++) {
            prefixSum[i] = (current + a[i]) % m;
            current = prefixSum[i];
        }
        
        TreeSet<Long> treeSet = new TreeSet<>();
        long max = prefixSum[0] % m;
        treeSet.add(max);
        for (int i = 1; i < len; i++) {
            treeSet.add(prefixSum[i]);
            Long minFollow = treeSet.higher(prefixSum[i]);
            if (minFollow != null) {
                long modulo = prefixSum[i] + m - minFollow;
                max = max > modulo ?  max : modulo;
            } else {
                max = max > prefixSum[i] ? max : prefixSum[i];
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
