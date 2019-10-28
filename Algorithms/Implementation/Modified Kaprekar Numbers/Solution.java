import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        boolean found = false;
        for (int i = p; i <= q; i++) {
            String s = String.valueOf(i);
            int l = s.length();
            long i2 = (long)i * i;
            String s2 = String.valueOf(i2);
            int l2 = s2.length();
            String subright = s2.substring(l2-l);
            String subleft = s2.substring(0, l2 - l);
            int n1;
            if (subleft.equals("")) {
                n1 = 0;
            } else {
                n1 = Integer.parseInt(subleft);
            }
            int n2 = Integer.parseInt(subright);
            if (n1 + n2 == i) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("INVALID RANGE");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
