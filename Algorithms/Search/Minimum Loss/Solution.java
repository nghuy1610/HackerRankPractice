import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumLoss function below.
        static long minimumLoss(long[] price) {
        long min = -1;
        int len = price.length;
        long[] temp = Arrays.copyOf(price, len);
        Arrays.sort(price);
        
        for (int i = 0; i < len-1; i++) {
            long small = price[i];
            long big = price[i+1];
            if (big - small != 0 && (min == -1 || big - small < min )) {
                int left = 0, right = len - 1;
                while (temp[left] != big) {left++;}
                while (temp[right] != small) {right--;}
                if (left < right) {
                    min = big - small;
                }
            }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        long result = minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
