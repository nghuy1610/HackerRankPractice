import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridlandMetro function below.
        static long gridlandMetro(int n, int m, int k, int[][] track) {
        Arrays.sort(track, new Comparator<int[]>() {
            @Override
            public int compare(int[] ar1, int[] ar2) {
                if (ar1[0] != ar2[0]) {return ar1[0] - ar2[0];}
                else if (ar1[1] != ar2[1]) {return ar1[1] - ar2[1];}
                else return ar1[2] - ar2[2];
            }
        });
        Map<Integer, Stack<int[]>>  map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int[] in = track[i];
            int r = in[0];
            Stack<int[]> trackStack = map.get(r);
            if (trackStack == null) {
                trackStack = new Stack<>();
                int[] trackR = new int[2];
                trackR[0] = track[i][1];
                trackR[1] = track[i][2];
                trackStack.push(trackR);
                map.put(r, trackStack);
            } else {
                int[] lastTrack = trackStack.peek();
                if (lastTrack[1] >= in[1]) {
                    if (in[2] > lastTrack[1]) {
                        lastTrack[1] = in[2];
                    }
                } else {
                    trackStack.push(new int[] {in[1], in[2]});
                }
            }
        }
        long count = 0;
        for (Stack<int[]> stack : map.values()) {
            while (!stack.isEmpty()) {
                int[] scope = stack.pop();
                count += scope[1] - scope[0] + 1;
            }
        }
        return (long)m * n - count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        long result = gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
