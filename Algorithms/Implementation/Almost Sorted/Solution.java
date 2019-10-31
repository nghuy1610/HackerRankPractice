import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        int len = arr.length;
        int[] sa = Arrays.copyOf(arr, len);
        boolean isSwap = true;
        boolean isReverse = true;
        Arrays.sort(sa);
        int l = -1, r = -1;
        int count = 0;
        outloop:
        for (int i = 0; i < len-1; i++) {
            if (sa[i] != arr[i]) {
                for (int j = i+1;j < len; j++) {
                    if(arr[j] == sa[i]) {
                        if (arr[i] == sa[j]) {
                            l = i; r = j;
                            count++;
                            if (count > 1) {
                                System.out.println("no");
                                return;
                            }
                            i = j + 1;
                            break;
                        }
                        else {
                            System.out.println("no");
                            return;
                        }
                    }
                }
            }
            
        }
        for (int i = l+1; i < r; i++) {
            if (sa[i] != arr[i]) {isSwap = false;}
        }
        for (int m = 1; m <= (r-l) /2; m++) {
            if (arr[l+m] != sa[r-m] && arr[r-m] != sa[l+m]) {
                isReverse = false;
            }
        }
        if ((l == -1 && r == -1) || isSwap || isReverse) {
            System.out.println("yes");
            if (isSwap) {System.out.println("swap " + (l+1) + " " + (r+1));}
            else if (isReverse) {System.out.println("reverse " + (l+1) + " " + (r+1));}
            
        } else {
            System.out.println("no");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
