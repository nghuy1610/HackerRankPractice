import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the equal function below.
    static int equal(int[] ar) {
        int count = 0;

        int min = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < min) {min= ar[i];}
        }
        int[] num = new int[5];
        for (int i = 0;i < ar.length;i++) {
            num[(ar[i] - min) % 5]++;
        }

        if (num[3] > num[1] + num[2] + num[0]) {min -= 2;}
        else if (num[4] > num[2] + num[0]) {min -= 1;}

        for (int i = 0; i < ar.length; i++) {
            int dif = ar[i] - min;
            count += dif / 5 + dif%5/2 + dif%5%2;
        }

        return count;

    }

    private static void rotateRight(int[] ar, int step) {
        for (int i = 0; i < ar.length; i++) {
            ar[(i+step) % ar.length] = ar[i];
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

