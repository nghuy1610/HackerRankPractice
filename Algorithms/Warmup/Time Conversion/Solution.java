import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int hh, mm, ss;
        String fm;
        String[] parts = s.split(":");
        hh = Integer.parseInt(parts[0]);
        mm = Integer.parseInt(parts[1]);
        ss = Integer.parseInt(parts[2].substring(0, 2));
        fm = parts[2].substring(2);
        if (fm.equals("AM")) {
            if (hh == 12) {
                hh = 0;
            }
        } else {
            if (hh != 12) {
                hh += 12;
            }
        }
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
