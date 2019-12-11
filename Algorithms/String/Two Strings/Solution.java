import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        int[] freq1 = new int['z' - 'a' + 1];
        int[] freq2 = new int['z' - 'a' + 1];
        for (char c : ca1) {
            freq1[c-'a']++;
        }
        for (char c : ca2) {
            freq2[c-'a']++;
        }
        for (int i = 0; i < 'z'-'a' + 1; i++) {
            if (freq1[i] > 0 && freq2[i] > 0) {
                return "YES";
            }
        }
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
