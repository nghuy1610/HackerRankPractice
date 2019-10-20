import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        quicksort(arr, 0, arr.length-1);
        for (int ss :  arr) {System.out.print(ss);}
        int[] rs = new int[arr.length];
        int cr = -1;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != cr) {
                rs[j] = arr.length - i;
                cr = arr[i];
                j++;
            }
        }
        return Arrays.copyOfRange(rs, 0, j);

    }

    static void quicksort(int ar[], int l, int r) {
        if (l >= r) {return;}
        int i = l;
        int pivot = ar[l];
        for (int j = l+1; j <= r; j++) {
            if (ar[j] < pivot) {
                int temp = ar[j];
                ar[j] = ar[++i];
                ar[i] = temp;
            }
        }
        ar[l] = ar[i];
        ar[i] = pivot;
        quicksort(ar, l, i - 1);
        quicksort(ar, i+1, r);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
