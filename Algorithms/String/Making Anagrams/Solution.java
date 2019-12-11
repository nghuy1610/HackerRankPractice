import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        char[] ca1 = s1.toCharArray();
        char[] ca2 = s2.toCharArray();
        int count = 0;
        int[] freq1 = new int['z' - 'a' + 1];
        int[] freq2 = new int['z' - 'a' + 1];
        for (char c : ca1) {
            freq1[c-'a']++;
        }
        for (char c : ca2) {
            freq2[c-'a']++;
        }
        for (int i = 0; i < freq1.length; i++) {
            count += freq1[i] > freq2[i]? freq1[i] - freq2[i] : freq2[i] - freq1[i];
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
