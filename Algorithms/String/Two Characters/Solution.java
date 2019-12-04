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

    // Complete the alternate function below.
    static int alternate(String s) {
        Set<String> set = new HashSet<>(Arrays.asList(s.split("")));
        List<String> cs = new ArrayList<>(set);
        int max = 0;
        for (int i = 0; i < cs.size()-1; i++) {
            for (int j = i+1; j < cs.size(); j++) {
                String temp = new String(s);
                String a = cs.get(i);
                String b = cs.get(j);
                temp = temp.replaceAll("[^" + a + b + "]", "");
                if ((temp.matches("(" + a + b + ")+" + a + "?") || temp.matches("(" + b + a + ")+" + b + "?") )&& temp.length() > max) {
                    max = temp.length();
                    
                }
            }
        }
        return max;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
