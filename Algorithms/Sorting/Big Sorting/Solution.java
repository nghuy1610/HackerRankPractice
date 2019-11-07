import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Comparator<String> cpr = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {return 1;}
                else if (s1.length() < s2.length()) {return -1;}
                else {
                    return s1.compareTo(s2);
                }
            }
        };
        Arrays.sort(unsorted, cpr);
       return unsorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            unsorted[i] = br.readLine();
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
        br.close();
        scanner.close();
    }
}
