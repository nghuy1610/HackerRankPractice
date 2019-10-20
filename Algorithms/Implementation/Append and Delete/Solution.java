import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int l1 = s.length();
        int l2 = t.length();
        if (k >= l1 + l2) {return "Yes";}
        else if (k < (l1>l2? l1-l2 : l2-l1)) {return "No";}
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int i = 0;
        for (; i < c1.length && i < c2.length; i++) {
            if (c1[i] != c2[i])
            break;
        }
        if (k == l1 + l2 - 2 * i) {
            return "Yes";
        } else if (k > l1 + l2 - 2 * i){
            if (i == 0) {return "Yes";}
            else {
                if ((k -l1 - l2) % 2 == 0) {return "Yes";}
                else {return "No";}
            }
        } else {
            return "No";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
