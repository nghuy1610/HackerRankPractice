import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        String temp = s.toLowerCase();
        int n  = 'z' - 'a' + 1;
        int[] e = new int[n];
        for (int i = 0; i < s.length(); i++) {
            char c = temp.charAt(i);
            if ('a' <= c && c <= 'z'){
                e[c-'a']++;
            }
        }
        for (int j = 0; j < e.length; j++) {
            if (e[j] == 0) {return "not pangram";}
        }
        return "pangram";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
