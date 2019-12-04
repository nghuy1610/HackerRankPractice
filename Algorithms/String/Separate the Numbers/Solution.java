import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        int len = s.length();
        if (len == 1) {System.out.println("NO");return;}
        char[] ca = s.toCharArray();
        int[] ns = new int[len];
        for (int i = 0; i < len; i++) {
            ns[i] = ca[i] - '0';
        }
        int lastdigit = ns[len-1];
        int j = len - 2;
        do {
            boolean found = false;
            while (j >= 0) {
                if ((ns[j] + 1) % 10 == lastdigit && ns[j+1] != 0) {
                    found = true;
                    break;
                }
                j--;
            }
            if (found) {
                long bignum = 0;
                for (int k = j+1; k < len; k++) {
                    bignum = bignum * 10 + ns[k];
                }
                int next = j;
                do {
                    long temp = bignum -1;
                    int m = next;
                    while (temp > 0 && m >= 0) {
                        if (temp % 10 != ns[m]) {break;}
                        temp /= 10;
                        m--;
                    }
                    if (temp != 0) {j--; break;}
                    else {
                        if (m == -1) {System.out.println("YES " + (bignum-1));return;}
                        else {
                            bignum--;
                            next = m;
                        }
                    }
                } while (true);
            } else {j--;}
        }while (j >= 0);
        System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
