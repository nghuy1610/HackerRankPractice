import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // static long findOccurencesSubSequence(String sequence, String subSequence) {
    //     int x = sequence.length();
    //     int y = subSequence.length();
    //     int row = x + 1;
    //     int col = y + 1;
    //     long[][] mat = new long[row][col];
    //     // Init default value
    //     // F(x,"") = 1, F("", a) = 0, F("","") = 1
    //     for (int i = 0; i < row; i++) {
    //         mat[i][0] = 1;
    //     }
    //     for (int j = 1; j < col; j++) {
    //         mat[0][j] = 0;
    //     }
    //     for (int i = 1; i < row; i++) {
    //         for (int j = 1; j < col; j++) {
    //             if (sequence.charAt(x-i) != subSequence.charAt(y-j)) {
    //                 mat[i][j] = mat[i-1][j];
    //             } else {
    //                 mat[i][j] = (mat[i-1][j] + mat[i-1][j-1]) % 1000000007l;
    //             }
    //         }
    //     }
    //     return mat[x][y];
    // }
    
    // static long shortPalindrome(String s) {
    //     long count = 0;
    //     for (char c = 'a'; c <= 'z'; c++) {
    //         for (char ch = 'a'; ch <= 'z'; ch++) {
    //             int i = 0, j = s.length() - 1;
    //             while (i < s.length() && s.charAt(i) != c) {i++;}
    //             while (j >= 0 && s.charAt(j) != c) {j--;}
    //             if (i < j) {
    //                 count = (count + findOccurencesSubSequence(s.substring(i, j+1), "" + c + ch + ch + c)) % 1000000007l;
    //             }
    //         }
    //     }
    //     return count;
    // }

        static long shortPalindrome(String s) {
        long count = 0;
        long module = 1000000007l;
        long[][][] mat3 = new long[26][26][26];
        long[][] mat2 = new long[26][26];
        long[] mat1 = new long[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                count = (count + mat3[c][j][j]) % module;
                mat3[j][c][c] = (mat3[j][c][c] +  mat2[j][c]) % module;
                mat2[j][c] = (mat2[j][c] + mat1[j]) % module;
            }
            mat1[c] = (mat1[c] + 1) % module;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = br.readLine();

        long result = shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
