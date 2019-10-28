import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    //If for each kind of ball we can find a container that has the capacity equals to the number of balls
    // then it's possible.
    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int size = container.length;
        int[] bs = new int[size];
        int[] cs = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bs[j] += container[i][j];
                cs[i] += container[i][j];
            }
        }
        for (int m = 0; m < size; m++) {
            boolean isFound = false;
            for (int n = m; n < size; n++){
                if (bs[m] == cs[n]){
                    isFound = true;
                    int temp = cs[n];
                    cs[n] = cs[m];
                    cs[m] = temp;
                    break;
                }
            }
            if (!isFound) {return "Impossible";}
        }

        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
