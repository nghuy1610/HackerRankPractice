import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        int a = b.indexOf("_");
        boolean isGood = true;
        char[] bar = b.toCharArray();
        for (int i = 0; i < b.length(); i++) {
            boolean b1 = false;
            boolean b2 = false;
            if (i - 1 >= 0 && bar[i-1] == bar[i]) {b1 = true;}
            if (i + 1 < b.length() && bar[i+1] == bar[i]) {b2 = true;}
            if (!b1 && !b2){isGood = false; break;}
        }
        if (isGood) {return "YES";}
        else if (a == -1) {return "NO";}
        else {
            for (int j = 0; j < b.length(); j++) {
                if (bar[j] != '_') {
                    boolean thantwo = false;
                    for (int k = j+1; k< b.length(); k++) {
                        if (bar[k] == bar[j]) {
                            thantwo = true;
                            bar[k] = '_';
                        }
                    }
                    if (!thantwo) {
                        return "NO";
                    }
                }
            }
        }
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
