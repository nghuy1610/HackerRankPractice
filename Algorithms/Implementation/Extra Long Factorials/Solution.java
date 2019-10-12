import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        int[] init = new int[200];
        init[0] = 1;
        for (int i = 1; i <= n; i++) {
            multiply(init, i);
        }
        int j = init.length-1;
        while(j >= 0 && init[j] == 0) {
            j--;
        }
        for (; j >= 0; j--) {     
            System.out.print(init[j]);
        }
    }

    static void multiply(int[] arr, int m) {
        int[] tempAr = Arrays.copyOf(arr, arr.length);
        int[] rs = new int[arr.length];
        int pos = 0;
        while (m > 0) {
            int bonus = 0;
            int digit = m % 10;
            pos++;
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i] * digit;
                tempAr[i] = (temp + bonus) % 10;
                bonus = (temp + bonus) / 10;
            }
            add(rs, shift(tempAr, pos-1), arr.length);
            m /= 10;
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = rs[k];
        }
    }

    static void add(int[] a, int[] b, int n) {
        int bonus = 0;
        for (int i = 0; i < n; i++) {
            int temp = a[i] + b[i];
            a[i] = (temp + bonus) % 10;
            bonus = (temp + bonus) / 10;
        }
    }

    static int[] shift(int a[], int n) {
        if (n == 0) {
            return a;
        }
        int[] b = new int[a.length];
        for (int i = a.length-1; i>=n; i--) {
            b[i] = a[i-n];
        }
        for (int j= 0; j < n; j++) {
            b[j] = 0;
        }
        return b;
    }
 
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
