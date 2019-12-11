import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        int len = s.length();
        int count = 0;
        int pos = -1;
        char[] ca = s.toCharArray();
        int l = 0, r = len - 1;
        while (l < r && count <= 1) {
            if (ca[l] != ca[r]) {
                count++; break;
            } else {
                l++; r--;
            }
        }
        if (count == 0) {return pos;}
        if (l + 1 < r && ca[l+1] == ca[r]) {
            int templ = l+1, tempr = r;
            pos = l;
            while (templ < tempr) {
                if (ca[templ] != ca[tempr]) {
                    count++;break;
                } else {
                    templ++; tempr--;
                }
            }
            if (count > 1) {pos = -1;}
            else {return pos;}
        }
        if (r - 1 > l && ca[r-1] == ca[l]) {
            count = 1;
            int templ2 = l, tempr2 = r-1;
            pos = r;
            while (templ2 < tempr2) {
                if (ca[templ2] != ca[tempr2]) {
                    count++; break;
                } else {
                    templ2++; tempr2--;
                }
            }
            if (count > 1) {pos = -1;}
            else {return pos;}
        }
        return pos;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
