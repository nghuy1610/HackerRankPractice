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

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        char[] ca = s.toCharArray();
        boolean found;
        do {
            found = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ca.length; i++) {
                if (i == ca.length - 1) {
                    sb.append(ca[i]);
                    break;
                }
                if (ca[i] != ca[i+1]) {
                    sb.append(ca[i]);
                } else {
                    found = true;
                    i++;
                }
            }
            ca = sb.toString().toCharArray();
        }
        while(found == true);
        return ca.length == 0 ? "Empty String" : new String(ca);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
