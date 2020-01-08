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
     * Complete the 'cutTheTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY data
     *  2. 2D_INTEGER_ARRAY edges
     */

        public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        // Write your code here
        int sum = 0;
        for (Integer i : data) {sum += i;}
        int size = data.size();
        List<List<Integer>> next = new ArrayList<>();
        for (int i = 0; i < size; i++) {next.add(new ArrayList<Integer>());}
        for (List<Integer> edge : edges) {
            Integer p1 = edge.get(0);
            Integer p2 = edge.get(1);
            next.get(p1-1).add(p2-1);
            next.get(p2-1).add(p1-1);
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        stack.push(Integer.valueOf(0));
        stackSum.push(Integer.valueOf(0));
        Set<Integer> traverse = new HashSet<>();
        traverse.add(Integer.valueOf(0));
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            for (Integer i : next.get(node)) {
                if (!traverse.contains(i)) {
                    stack.push(i);
                    stackSum.push(i);
                }
            }
            traverse.add(node);
        }
        traverse.clear();
        while (!stackSum.isEmpty()) {
            Integer node = stackSum.pop();
            for (Integer i : next.get(node)) {
                if (traverse.contains(i)) {
                    data.set(node, data.get(node) + data.get(i));
                }
            }
            traverse.add(node);
        }
        
        int min = sum;
        for (Integer i : data) {
            int branch1 = sum - i;
            int branch2 = i;
            int temp = branch1 > branch2 ? branch1 - branch2 : branch2 - branch1;
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
