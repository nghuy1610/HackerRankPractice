import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridSearch function below.
        static String gridSearch(String[] G, String[] P) {
        int x1 = G.length;
        int x2 = P.length;
        int j = 0;
        List<int[]> pos = new ArrayList<>();
        for (; j < x1 - x2 + 1; j++) {
            int lastIndex = G[j].indexOf(P[0]);
            while (lastIndex != -1) {
                pos.add(new int[] {j, lastIndex});
                lastIndex = G[j].indexOf(P[0], lastIndex + 1);
            }
        }
        if (pos.size() == 0) {
            return "NO";
        }
        outloop:
        for (int m = 0; m < pos.size(); m++) {
            int r = pos.get(m)[0];
            int c = pos.get(m)[1];
            for (int i = 1; i < x2; i++) {
                int temp = G[r+i].indexOf(P[i]);
                while (temp != c && temp != -1)  {
                    temp = G[r+i].indexOf(P[i], temp + 1);
                }
                if (temp == c) {continue;}
                else {continue outloop;}
            }
            return "YES";
        }
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
