import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'initialize' function below.
     *
     * The function accepts STRING s as parameter.
     */
    static long[] fact;
    static int[] totalCount = new int[26];
    static String original;

    public static void initialize(String s) {
        original = s;
        int n = s.length();
        fact = new long[n];
        fact[0] = 1l;
        for (int i = 1; i < n; i++) {
            fact[i] = (fact[i-1] * i) % 1000000007l;
        }
        for (int i = 0; i < n; i++) {
            totalCount[s.charAt(i) - 'a']++;
        }
    }
    
    static long squaringExponentationMod(long n, long ex) {
        if (n == 0) {return 1l;}
        long y = 1l;
        while (ex > 1) {
            if (ex  % 2 == 0) {
                n = (n * n) % 1000000007l;
                ex /= 2;
            } else {
                y = (y * n) % 1000000007l;
                n = (n * n) % 1000000007l;
                ex /= 2;
            }
        }
        return (y * n) % 1000000007l;
    }
    
    public static long answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
            int[] count;
            int n = original.length();
            if (r - l > n/2) {
                count = Arrays.copyOf(totalCount, 26);
                for (int i = 0; i < l - 1; i++) {
                    count[original.charAt(i)-'a']--;
                }
                for (int i = r; i < n; i++) {
                    count[original.charAt(i)-'a']--;
                }
            } else {
                count = new int[26];
                for (int i = l-1; i < r; i++) {
                    count[original.charAt(i) - 'a']++;
                }
            }
            int[] pair = new int[26];
            for (int i = 0; i < 26; i++) {
                pair[i] = count[i] / 2;
            }
            int totalPair = 0;
            long dup = 1l;
            for (int i = 0; i < pair.length; i++) {
                int lg = pair[i];
                totalPair += lg;
                dup = (dup * squaringExponentationMod(fact[lg], 1000000007l-2)) % 1000000007l;
            }
            long remaining = r + 1 - l - totalPair * 2;
            if (remaining == 0) {remaining = 1;}
            long pos = (fact[totalPair] * remaining) % 1000000007l;
            return (pos * dup) % 1000000007l ;
        }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        Result.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for(int i = 0; i < q; i++) {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                long result = Result.answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
