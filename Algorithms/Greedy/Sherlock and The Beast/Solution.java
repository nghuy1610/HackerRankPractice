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

    // Complete the decentNumber function below.
        static void printInt(int n, int time) {
        for (int i = 0; i < time; i++) {
            System.out.print(n);
        }
    }
        static void decentNumber(int n) {
        if (n % 3 == 0) {
            printInt(5, n);
        } else if (n < 3) {
            System.out.print(-1);
        } else {
            int len  = n - 5;
            if (len < 0) {
                System.out.println(-1);
                return;
            } else {
                if (len % 3 != 0) {
                    len -= 5;
                }
                if (len < 0) {
                    System.out.println(-1);
                    return;
                }
            }
            printInt(5, len);
            printInt(3, n-len);
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
