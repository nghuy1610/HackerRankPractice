import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fairRations function below.
    static String fairRations(int[] b) {
        int count = 0;
        int i = 0, j = b.length-1;
        while (true) {
            while (b[i] % 2 == 0 && i < j) {i++;}
            while (b[j] % 2 == 0 && j > i) {j--;}
            if (i >= j) {
                if (b[i] % 2 != 0 || b[j] % 2 != 0) {return "NO";}
                else {break;}
            }
            if (i + 1 == j) {
                count += 2;
                break;
            } else {
                count += 4;
                b[i]++;b[i+1]++;
                b[j]++;b[j-1]++;
            }
        }
        return String.valueOf(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        String result = fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
