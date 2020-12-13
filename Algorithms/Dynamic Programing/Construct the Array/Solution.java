import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final long BASE = 1000000007;
    // Complete the countArray function below.
	// Consider f(i,j) is the way construct array end with j and have i element
	// f(i,j) = sum of f(i-1, j = 1->k without j) = sum of f(i-1, all j) - f(i-1, j) 
	// due to f(1, 1) = 1 and f(1, any) == 0, f(i, 2) = f(i,3) = ...
    static long countArray(int n, int k, int x) {
        long[] src = new long[2];
        src[0] = 1;

        long lastSum = 1;
        for (int i = 1; i < n-1; i++) {
            src[0] = (lastSum - src[0]) % BASE;
            src[1] = (lastSum - src[1]) % BASE;
            lastSum = src[0] + (k-1) * src[1];
        }
        if (x == 1) {
            return (lastSum - src[0]) % BASE;
        } else {
            return (lastSum - src[1]) % BASE;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkx = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkx[0]);

        int k = Integer.parseInt(nkx[1]);

        int x = Integer.parseInt(nkx[2]);

        long answer = countArray(n, k, x);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

