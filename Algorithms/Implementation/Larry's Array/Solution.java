import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void rotate2(int[] A, int src, int dest) {
        while (src != dest) {
            int temp = A[src];
            A[src] = A[src-1];
            A[src-1] = A[src-2];
            A[src-2] = temp;
            src -= 2;
        }
    }
    
    static void rotate(int[] A, int src, int dest) {
        if (src == dest) {return;}
        if ((src - dest) % 2 == 0) {
            rotate2(A, src, dest);
        } else {
            int temp = A[src];
                if (src + 1 < A.length) {
                A[src] = A[src+1];
                A[src+1] = A[src-1];
                A[src-1] = temp;
            } else {
                A[src] = A[src-2];
                A[src-2] = A[src-1];
                A[src-1] = temp;
            }
                src--;
            rotate2(A, src, dest);
        }
        
    }
    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {
        int len = A.length;
        int[] B = Arrays.copyOf(A, len);
        Arrays.sort(B);
        for (int i = 0; i < len-2; i++) {
            for (int j = i; j < len; j++) {
                if (A[j] == B[i] && i != j) {
                    rotate(A, j, i);
                }
            }
        }
        if (A[len-1] == B[len-1]) {
            return "YES";
        } else {
            return "NO";
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

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            String result = larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
