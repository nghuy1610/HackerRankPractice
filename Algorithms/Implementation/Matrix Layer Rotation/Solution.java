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

        static void findNewPos(int[][] rs, int i, int j, int min, int step, int row, int col, int val) {
        if (min == -1 || step == 0) {
            rs[i][j] = val;
            return;
        }
        while (step > 0)
            {
            if (i == min && j > min) {
                if (j - min < step) {
                    step -= j-min;
                    j = min;
                } else {
                    j -= step;
                    step = 0;
                }
            } else if (j == min && i < row - 1 - min) {
                if (row -1 - min - i < step) {
                    step -= row - 1 - min - i;
                    i = row -1 - min;
                } else {
                    i += step;
                    step = 0;
                }
            } else if (i == row - 1 -min && j < col - 1 - min) {
                if (col -1 - min - j < step) {
                    step -= col - 1 - min - j;
                    j = col -1 -min;
                } else {
                    j += step;
                    step = 0;
                }
            } else if (j == col - 1 - min && i > min) {
                if (i - min < step) {
                    step -= i - min;
                    i = min;
                } else {
                    i -= step;
                    step = 0;
                }
            }
        }
        rs[i][j] = val;
    }

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int row = matrix.size();
        int col = matrix.get(0).size();
        int[][] ar = new int[row][col];
        int[][] rs = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ar[i][j] = matrix.get(i).get(j).intValue();
            }
        }
        int sub = (row+1) / 2 > (col+1) / 2? (col+1)/2 : (row+1)/2;
        int[] ss = new int[sub];
        for (int i = 0, j = 0; i < row - i - 1 && j < col - j - 1; i++, j++) {
            int size = (row - 2*i - 1 + col - 2*j -1) * 2;
            int step = r % size;
            ss[i] = step;
            
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int minr = i > row - i - 1? row - i - 1 : i;
                int minc = j > col - j - 1? col - j - 1 : j;
                int min  = minr > minc ? minc : minr;
                int st = -1;
                if (min < ss.length) {st = ss[min];}
                findNewPos(rs, i, j, min, st, row, col, ar[i][j]);
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(rs[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
