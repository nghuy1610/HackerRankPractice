import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
     static int dfs(int[][] matrix, int x, int y, int r, int c) {
        int count = 1;
        matrix[x][y] = 0;
        int[] bonus = new int[] {-1, 0, 1};
        for (int i : bonus) {
            for (int j : bonus) {
                if (x + i >= 0 && x + i < r && y + j >= 0 && y + j < c) {
                    if (matrix[x+i][y+j] == 1) {
                        count += dfs(matrix, x+i, y + j, r, c);
                    }
                }
            }
        }
        return count;
    }

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int max = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    int n = dfs(matrix, i, j, r, c);
                    max = max > n ? max : n;
                }
            }
        }
        return max;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
