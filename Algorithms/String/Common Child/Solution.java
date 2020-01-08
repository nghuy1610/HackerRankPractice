import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    // Longest common subsequence problem
    static int commonChild(String s1, String s2) {
        int len = s1.length();
        int[][] table = new int[len+1][len+1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    table[i][j] = table[i-1][j-1] + 1;
                } else {
                    table[i][j] = table[i-1][j] > table[i][j-1]? table[i-1][j] : table[i][j-1];
                }
            }
        }
        return table[len][len];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
