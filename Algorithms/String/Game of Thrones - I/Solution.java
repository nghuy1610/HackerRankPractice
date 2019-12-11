import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        char[] ca = s.toCharArray();
        int[] freq = new int['z' - 'a' + 1];
        for (char c : ca) {
            freq[c-'a']++;
        }
        int count = 0;
        for (int i : freq) {
            if (i % 2 != 0) {count++;}
        }
        if (count > 1) {
            return "NO";
        } else {
            return "YES";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
