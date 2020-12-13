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

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
	// tabulation f(n, m) = f(n-0*coinVal, m-1) + f(n-1*coinVal, m-1) + ....
	// coinVal is value of m-th coin, f(n, m) is number of change if use m first coin for the value of n
	// when m = 1, f(n, m) = n % m == 0 ? 1 : 0
    public static long getWays(int n, List<Long> coins) {
    // Write your code here
        int nCoins = coins.size();
        long[][] table = new long[nCoins][n+1];
        long firstCoin = coins.get(0);
        for(int j = 0; j <= n; j++) {
            if (j % firstCoin == 0) {
                table[0][j] = 1;
            }
        }
        for (int i = 1; i < nCoins; i++) {
            for (int j = 0; j <= n; j++) {
                long coinVal = coins.get(i);
                long tmp = 0;
                int tmpJ = j;
                while (tmpJ >= 0) {
                    tmp += table[i-1][tmpJ];
                    tmpJ -= coinVal;
                }
                table[i][j] = tmp;
            }
        }
        return table[nCoins-1][n];
    }

    // memoization
    static long[][] table;
    private static long getWaysV2(int n, List<Long> coins) {
        table = new long[coins.size()][n+1];
        return findNChanges(n, coins);
    }

    private static long findNChanges(int n, List<Long> coins) {
        int nCoins = coins.size();
        long result = 0;
        if (n == 0) {
            result = 1;
        } else if (nCoins == 1) {
            result = n % coins.get(0) == 0 ? 1 : 0;
        } else {
            int tmp = n;
            long count = 0;
            while (tmp >= 0) {
                if (table[nCoins-2][tmp] != 0) {
                    count += table[nCoins - 2][tmp];
                } else {
                    count += findNChanges(tmp, coins.subList(0, nCoins - 1));
                }
                tmp -= coins.get(nCoins-1);
            }
            result = count;
        }
        table[coins.size()-1][n] = result;
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

