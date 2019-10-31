import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        int r = grid.length;
        int c = grid[0].length();
        String[] rs2 = new String[r];
        String[] rs3 = new String[r];
        String[] rs1 = new String[r];
        char[][] chargr = new char[r][c];
        char[][] chargr1 = new char[r][c];
        char[][] chargr2 = new char[r][c];
        for (int i = 0; i < r ; i++) {
            char[] ac = grid[i].toCharArray();
            chargr[i] = ac;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                chargr2[i][j] = 'O';
                boolean mid = false;
                boolean top = false;
                boolean bot = false;
                boolean left = false;
                boolean right = false;
                if (i - 1 < 0) {left = true;}
                else if (chargr[i-1][j] != 'O') {left = true;}
                if (i + 1 >= r) {right = true;}
                else if (chargr[i+1][j] != 'O') {right = true;}
                if (j -1 < 0) {top = true;}
                else if (chargr[i][j-1] != 'O') {top = true;}
                if (j + 1 >= c) {bot = true;}
                else if (chargr[i][j+1] != 'O') {bot = true;}
                if (chargr[i][j] != 'O') {mid = true;}
                if (top && bot && left && right & mid) {chargr[i][j] = 'x';}
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (chargr[i][j] == 'x'){
                    chargr[i][j] = 'O';
                } else {
                    chargr[i][j] = '.';
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean mid = false;
                boolean top = false;
                boolean bot = false;
                boolean left = false;
                boolean right = false;
                if (i - 1 < 0) {left = true;}
                else if (chargr[i-1][j] != 'O') {left = true;}
                if (i + 1 >= r) {right = true;}
                else if (chargr[i+1][j] != 'O') {right = true;}
                if (j -1 < 0) {top = true;}
                else if (chargr[i][j-1] != 'O') {top = true;}
                if (j + 1 >= c) {bot = true;}
                else if (chargr[i][j+1] != 'O') {bot = true;}
                if (chargr[i][j] != 'O') {mid = true;}
                if (top && bot && left && right & mid) {chargr1[i][j] = 'x';}
                else {chargr1[i][j] = chargr[i][j];}
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (chargr1[i][j] == 'x'){
                    chargr1[i][j] = 'O';
                } else {
                    chargr1[i][j] = '.';
                }
            }
        }
        for (int i = 0; i < r; i++) {
            rs3[i] = String.valueOf(chargr[i]);
            rs2[i] = String.valueOf(chargr2[i]);
            rs1[i] = String.valueOf(chargr1[i]);
        }
        if (n == 0 || n == 1) {return grid;}
        else if (n % 2 == 0) {return rs2;}
        else if (n % 4 == 3) {return rs3;}
        else {return rs1;}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

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
