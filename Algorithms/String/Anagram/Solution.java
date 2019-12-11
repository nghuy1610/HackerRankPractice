import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        int len = s.length();
        if (len % 2 == 1) {return -1;}
        char[] ca = s.toCharArray();
        int mid = len/2;
        boolean isFound;
        int count = 0;
        for (int i = 0; i < mid; i++) {
            isFound = false;
            for (int j = mid; j < len; j++) {
                if (ca[j] == ca[i]) {
                    isFound = true;
                    ca[j] = '0';
                    ca[i] = '0';
                    break;
                }
            }
            if (!isFound) {count++;}
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
