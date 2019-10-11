import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

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

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int sk = keyboards.length;
        int sd = drives.length;
        quicksort(keyboards, 0, sk -1);
        quicksort(drives, 0, sd-1);
        int max = -1;
        for (int i = 0; i < sk; i++) {
            int m = sd - 1;
            for (int j = m; j >= 0; j--) {
                int sum = keyboards[i] + drives[j];
                if (sum <= b ) {
                    if (sum > max) {
                        max = sum;
                    }
                    m = j;
                    break;
                }
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
