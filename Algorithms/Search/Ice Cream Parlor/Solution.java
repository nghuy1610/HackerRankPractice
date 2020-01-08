import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int[] icecreamParlor(int m, int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (arr[i] + arr[j] != m) {
            if (arr[i] + arr[j] > m) {
                j--;
            } else {
                i++;
            }
        }
        int val1 = arr[i], val2 = arr[j];
        for (int k = 0; k < arr.length; k++) {
            if (temp[k] == val1) {
                val1 = k;break;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            if (temp[k] == val2) {
                val2 = k; break;
            }
        }
        if (val1 == val2) {val2++;}
        if (val1 < val2) {
            return new int[] {val1+1, val2+1};
        } else{
            return new int[] {val2+1, val1+1};
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

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
