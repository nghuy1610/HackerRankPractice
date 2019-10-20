import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int max = 0;
        int count = 0;
        List<char[]> tops = new ArrayList();
        for (String s : topic) {
            tops.add(s.toCharArray());
        }
        for (int i  = 0; i < tops.size()-1; i++) {
            for (int j = i ; j < tops.size(); j++) {
                int cr = 0;
                for (int k = 0; k < tops.get(i).length; k++) {
                    cr += tops.get(i)[k] + tops.get(j)[k] - 2 * '0' > 0 ? 1 : 0;
                }
                if (cr > max) {max = cr; count = 1;}
                else if (cr == max) {count++;}
            }
        }
        return new int[] {max, count};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
