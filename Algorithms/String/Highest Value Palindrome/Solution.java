import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        char[] ca = s.toCharArray();
        int[] pos = new int[n/2];
        int i;
        for (i = 0; i < n /2 && k > 0; i++) {
            if (ca[i] > ca[n-1-i]) {
                ca[n-1-i] = ca[i];
                pos[i] = 1;
                k--;
            } else if (ca[i] < ca[n-1-i]) {
                ca[i] = ca[n-1-i];
                pos[i] = 1;
                k--;
            }
        }
        while (i < n/2) {
            if (ca[i] != ca[n-i-1]) {
                return "-1";
            }
            i++;
        }
        int j;
        boolean isReplace;
        for (j = 0; j < n/2 && k >= 1; j++) {
            isReplace = false;
            if (ca[j] != '9') {
                if (pos[j] == 1 && k >= 1) {k-=1; isReplace = true;}
                else if (k >= 2){k-=2; isReplace = true;}
                if (isReplace) {
                    ca[j] = '9';
                    ca[n-j-1] = '9';
                }
            }
        }
        if (n % 2 != 0 && k >= 1) {ca[n/2] = '9';}
        return String.valueOf(ca);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
