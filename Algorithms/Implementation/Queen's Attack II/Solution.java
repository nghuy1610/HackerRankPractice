import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // Count all possible postition without obstacles then count maximum number 
        // position hiden by obstacles in each of 8 way.
        int[] md = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
        int max =  3 * (n-1);
        int rmin = r_q - 1 > n - r_q ? n - r_q : r_q - 1;
        int cmin = c_q - 1 > n - c_q  ? n - c_q : c_q - 1;
        int dmin = rmin > cmin ? cmin : rmin;
        if (dmin > 0) {max += 2*dmin;}
        for (int i =0; i < k; i++) {
            int or = obstacles[i][0];
            int oc = obstacles[i][1];
            if (or == r_q){
                if (oc > c_q && n - oc + 1 > md[1]) {md[1] = n - oc + 1;}
                else if (oc < c_q && oc > md[0]) {md[0] = oc;}
            } else if (oc == c_q) {
                if (or > r_q && n -or + 1 > md[3]) {md[3] = n - or + 1;}
                else if (or < r_q && or > md[2]) {md[2] = or;}
            } else if (or - oc == r_q - c_q) {
                if (r_q > c_q) {
                    if (or > r_q && n + 1 - or > md[5]) {
                        md[5] = n + 1 - or;
                    } else if (or < r_q && oc > md[4]){
                        md[4] = oc;
                    }
                } else {
                    if (or > r_q && n - oc + 1 > md[5]) {md[5] = n - oc + 1;}
                    else if (or < r_q && or > md[4]) {md[4] = or;}
                }
            } else if (or + oc == r_q + c_q) {
                if (r_q + c_q > n + 1) {
                    if (or > r_q && n + 1 - or > md[7]) {md[7] = n + 1 - or;}
                    else if (or < r_q && n - oc + 1 > md[6]) {md[6] = n - oc + 1;}
                } else {
                    if (or > r_q && oc > md[7]) {md[7] = oc;}
                    else if (or < r_q && or > md[6]) {md[6] = or;}
                }
            }
        }
        for (int o = 0; o < 8; o++) {
            max -= md[o];
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
