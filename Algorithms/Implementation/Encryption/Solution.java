import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        String a = s.replaceAll(" ", "");
        char[] ar = a.toCharArray();
        int l = a.length();
        int sq = (int)Math.sqrt(l);
        int x, y;
        if (sq * sq >= l) {
            x = sq; y = sq;
        } else if (sq * (sq+1) >= l) {
            x = sq; y = sq + 1;
        } else {
            x = sq + 1; y = sq + 1;
        }
        String rs = "";
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (j * y + i >= l){
                    break;
                } else {
                    rs += ar[j * y + i];
                }
            }
            rs += " ";
        }
        return rs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
