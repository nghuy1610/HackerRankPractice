import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String[] sa = {"one", "two", "three", "four", "five", "six", "seven", "eight", 
                        "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen"};
        String rs = "";
        String min = " minute";
        if (m == 0) {
            return sa[h-1] + " o' clock";
        } else if (m < 30) {
            if (m < 20) {
                rs = sa[m-1];
            } else if (m == 20) {
                rs = "twenty";
            } else {
                rs = "twenty " + sa[m-21];
            }
            if (m == 15) {min = "";}
            else if (m > 1) {min += "s";}
            
            return rs + min+ " past " + sa[h-1];
        } else if (m == 30) {
            return "half past " + sa[h-1];
        } else {
            m = 60 - m;
            if (m < 20) {
                rs = sa[m-1];
            } else if (m == 20) {
                rs = "twenty";
            } else {
                rs = "twenty " + sa[m-21];
            }
            if (m == 15) {min = "";}
            else if (m > 1) {min += "s";}
            
            return rs + min + " to " + sa[h % 12];
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
