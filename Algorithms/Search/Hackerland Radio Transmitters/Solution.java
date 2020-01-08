import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        int size = x.length;
        quicksort(x, 0, size - 1);
        int count = 0;
        for (int l = 0; l < size; l++) {
            int m;
            for (m = l + 1; m < size; m++) {
                if (x[m] > x[l] + k) {
                    m--;
                    break;
                }
            }
            count++;
            int r;
            for (r = m + 1; r < size; r++) {
                if (x[r] > x[m] + k) {
                    r--;
                    break;
                }
            }
            l = r;
        }
        return count;
    }

    static void quicksort(int[] x, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = x[l];
        int id = l;
        for (int i = l + 1; i <= r; i++) {
            if (x[i] < pivot) {
                int temp = x[++id];
                x[id] = x[i];
                x[i] = temp;
            }
        }
        x[l] = x[id];
        x[id] = pivot;
        quicksort(x, l, id - 1);
        quicksort(x, id + 1, r);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
