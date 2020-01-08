import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static boolean isAnagram(String s1, String s2) {
        int n = s1.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    static int sherlockAndAnagrams(String s) {
        int n = s.length();
        Set<Integer> counted = new HashSet<>();
        int count = 0;
        int sCount = 0;
        for (int i = 1; i < n; i++) {
            counted.clear();
            for (int j = 0; j < n-i; j++) {
                String f1 = s.substring(j, j+i);
                counted.add(j);
                sCount = 1;
                for (int k = j + 1; k <= n-i; k++) {
                    if (counted.contains(k)) {continue;}
                    String f2 = s.substring(k, k + i);
                    if (isAnagram(f1, f2)) {
                        sCount++;
                        counted.add(k);
                    }
                }
                count += sCount * (sCount-1) / 2;
            }
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

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
