import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        char[] ca = s.toCharArray();
        int[] freq = new int[26];
        for (char c : ca) {
            freq[c-'a']++;
        }
        int count = 0;
        int i = 0;
        int value;
        while ((value = freq[i]) == 0) {
            i++;
        }
        for (;i < 26; i++) {
            if (freq[i] != 0 && freq[i] != value) {
                count++;
            }
        }
        if (count > 1) {return "NO";}
        else {return "YES";}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
