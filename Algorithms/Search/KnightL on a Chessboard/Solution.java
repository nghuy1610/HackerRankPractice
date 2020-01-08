import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the knightlOnAChessboard function below.
    static int[][] knightlOnAChessboard(int n) {
        int[][] rs = new int[n-1][n-1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int[][] board = new int[n][n];
                board[0][0] = 1;
                int ab = 1;
                while (true) {
                    boolean isFound = false;
                    for (int z = 0; z < n; z++) {
                        for (int t = 0; t < n; t++) {
                            if (board[z][t] != 0) {continue;}
                            int min = n * n;
                            int val;
                            if (z + i < n) {
                                if (t + j < n) {
                                    val = board[z+i][t+j];
                                    if (val != 0) {min = val < min ? val : min;}                                    
                                }
                                if (t - j >= 0) {
                                    val =  board[z+i][t-j];
                                    if (val != 0) {min = val < min ? val : min;}
                                }
                            }
                            if (z - i >= 0) {
                                if (t + j < n) {
                                    val = board[z-i][t+j];
                                    if (val != 0) {min = val < min ? val : min;}
                                }
                                if (t - j >= 0) {
                                    val =  board[z-i][t-j];
                                    if (val != 0) {min = val < min ? val : min;}
                                }
                            }
                            if (z + j < n) {
                                if (t + i < n) {
                                    val = board[z+j][t+i];
                                    if (val != 0) {min = val < min ? val : min;}
                                }
                                if (t - i >= 0) {
                                    val =  board[z+j][t-i];
                                    if (val != 0) {min = val < min ? val : min;}
                                }
                            }
                            if (z - j >= 0) {
                                if (t + i < n) {
                                    val = board[z-j][t+i];
                                    if (val != 0) {min = val < min ? val : min;}
                                }
                                if (t - i >= 0) {
                                    val =  board[z-j][t-i];
                                    if (val != 0) {min = val < min ? val : min;}
                                }
                            }
                            if (min != n * n  && min == ab) {
                                isFound = true;
                                board[z][t] = min+1;
                            }
                        }
                    }
                    if (!isFound || board[n-1][n-1] != 0) {break;}
                    ab++;
                }
                if (board[n-1][n-1] != 0) {
                    rs[i-1][j-1] = board[n-1][n-1] - 1;
                } else {
                    rs[i-1][j-1] = -1;
                }
            }
        }
        return rs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                bufferedWriter.write(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
