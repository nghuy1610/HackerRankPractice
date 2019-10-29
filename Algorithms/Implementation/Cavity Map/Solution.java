import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        int s = grid.length;
        String all = "";
        for (String str : grid) {
            all += str;
        }
        char[] ca = all.toCharArray();
        for (int i = s + 1; i < s * (s-1); i++) {
            if (i % s != 0 && i % s != s - 1) {
                if (ca[i] > ca[i +1] && ca[i] > ca[i-1] && ca[i] > ca[i-s] && ca[i] > ca[i+s]) {
                    ca[i] = 'X';
                }
            }
        }
        String rs = String.valueOf(ca);
        System.out.println(rs);
        String[] result = new String[s];
        for (int j = 0; j < s; j++) {
            result[j] = rs.substring(j * s, (j+1)*s);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
