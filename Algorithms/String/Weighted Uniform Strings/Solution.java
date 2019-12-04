import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        int l = s.length();
        int n = queries.length;
        String[] rs = new String[n];
        Set<Integer> set = new HashSet<>();
        int last = -1;
        for (int i = l-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (i+1 < l && c == s.charAt(i+1)) {
                last -= c- 'a'+1;
                set.add(last);
            } else {
                int count = 0;
                int temp = i;
                while (temp >= 0 && s.charAt(temp)==c){
                    count += c - 'a' + 1;
                    temp--;
                }
                last = count;
                set.add(Integer.valueOf(count));
            }
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(Integer.valueOf(queries[i]))) {
                rs[i] ="Yes";
            } else {
                rs[i] = "No";
            }
        }
        return rs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int queriesCount = Integer.parseInt(br.readLine());

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            queries[i] = Integer.parseInt(br.readLine());
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < queriesCount-1; i++) {
            bufferedWriter.write(result[i]+"\n");
        }
        bufferedWriter.write(result[queriesCount-1]);

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
