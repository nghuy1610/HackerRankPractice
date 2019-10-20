import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int l = s.length();
        int r = (int)(n % l);
        char[] ls = s.toCharArray();
        int count = 0;
        for (int i = 0; i < r; i++) {
            if (ls[i] == 'a') {count++;}
        }
        if (n < l) {return count;}
        int a = 0;
        for (int j = 0; j < l; j++) {
            if (ls[j] == 'a') {a++;}
        }
        return a * (n/l) + count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
