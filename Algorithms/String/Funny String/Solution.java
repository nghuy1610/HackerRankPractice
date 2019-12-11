import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0, j = ca.length-1; i < j; i++, j--) {
            int ld = ca[i] > ca[i+1]? ca[i] - ca[i+1] : ca[i+1] - ca[i];
            int rd = ca[j] > ca[j-1]? ca[j] - ca[j-1] : ca[j-1] - ca[j];
            if (ld != rd) {return "Not Funny";}
        }
        return "Funny";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
