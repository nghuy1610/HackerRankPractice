import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char[] ca = w.toCharArray();
        for (int i = ca.length - 2; i >= 0; i--) {
            int pos = -1;
            for (int j = i+1; j < ca.length; j++) {
                if (ca[j] > ca[i]) {
                    if (pos == -1) {pos = j;}
                    else if (ca[j] < ca[pos]) {pos = j;}
                }
            }
            if (pos != -1) {
                char temp = ca[i];
                ca[i] = ca[pos];
                ca[pos] = temp;
                Arrays.sort(ca, i +1, ca.length);
                return String.valueOf(ca);
            }   
        }
        return "no answer";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
