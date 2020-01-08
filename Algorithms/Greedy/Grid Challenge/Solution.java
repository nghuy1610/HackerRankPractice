import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
       int row = grid.length;
        int col = grid[0].length();
        char[][] chAr = new char[row][col];
        for (int i = 0; i < row; i++) {
            char[] temp = grid[i].toCharArray();
            Arrays.sort(temp);
            chAr[i] = temp;
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row-1; j++) {
                if (chAr[j+1][i] < chAr[j][i]) {
                    return     "NO";
                }
            }
        }
        return "YES"; 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
