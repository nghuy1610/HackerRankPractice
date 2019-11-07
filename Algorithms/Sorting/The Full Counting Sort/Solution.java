import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {
        StringBuilder rs = new StringBuilder("");
        int len = arr.size();
        StringBuilder[] sList = new StringBuilder[100];
        for (int i = 0; i < 100; i++) {
            sList[i] = new StringBuilder("");
        }
        for (int i = 0; i < len; i++) {
            int n = Integer.parseInt(arr.get(i).get(0));
            if (i < len / 2) {
                sList[n].append("- ");
            } else {
                sList[n].append(arr.get(i).get(1) + " ");
            }
        }
        for (StringBuilder ls : sList) {
           rs.append(ls);
        }
        System.out.println(rs.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder rs = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());

        StringBuilder[] sList = new StringBuilder[100];
        for (int i = 0; i < 100; i++) {
            sList[i] = new StringBuilder("");
        }

        for (int i = 0; i < n; i++) {
            String[] pa = br.readLine().split(" ");
            int pos = Integer.parseInt(pa[0]);
            if (i < n / 2) {
                sList[pos].append("- ");
            } else {
                sList[pos].append(pa[1] + " ");
            }
        }
        for (StringBuilder ls : sList) {
            rs.append(ls);
         }
         System.out.println(rs.toString());
         
        br.close();
    }
}
