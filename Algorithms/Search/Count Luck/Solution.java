import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
       static String countLuck(String[] matrix, int k) {
        
        int row = matrix.length;
        int col = matrix[0].length();
        char[][] mat = new char[row][col];
        for (int i = 0; i < row; i++) {
            mat[i] = matrix[i].toCharArray();
        }
        int x1 = -1, y1 = -1;
        int x2 = -1, y2 = -1;
        for (int i = 0; i < row && (x1 == -1 || x2 == -1); i++) {
            for (int j = 0; j < col && (x1 == -1 || x2 == -1); j++) {
                if (mat[i][j] == 'M') {
                    x1 = i; y1 = j;
                } else if (mat[i][j] == '*') {
                    x2 = i; y2 = j;
                }
            }
        }
        int turn = -1;
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[] {x1, y1, 0});
        mat[x1][y1] = 'X';
        int[][] directions = new int[][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!stack.isEmpty()) {
            Integer[] cur = stack.pop();
            int x = cur[0], y = cur[1], z = cur[2];
            if (x == x2 && y == y2) {
                turn =  z;
                break;
            }
            List<Integer[]> moves = new ArrayList<>();
            for (int[] direction : directions) {
                int dx = direction[0], dy = direction[1];
                if (x + dx >= row || x + dx < 0 || y + dy >= col || y + dy < 0) {
                    continue;
                }
                if (mat[x+dx][y+dy] != 'X') {
                    mat[x+dx][y+dy] = 'X';
                    moves.add(new Integer[] {x+dx, y+dy, z});
                }
            }

            for (Integer[] move : moves) {
                if (moves.size() > 1) {
                    move[2]++;
                }
                stack.push(move);
            }
        }
        if (turn == k) {return "Impressed";}
        else {return "Oops!";}
    }
       
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
