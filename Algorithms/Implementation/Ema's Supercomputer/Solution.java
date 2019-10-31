import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

        static int findMaxPlus(char[][] ca, List<int[]> pos) {
        int max1 = -1;
        int r  = ca.length;
        int c = ca[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int le = 0;
                int m = -1;
                boolean isFound = false;
                while (i - le >= 0 && i+le < r && j -le >= 0 && j+le < c) {
                    if (ca[i-le][j] == 'G' && ca[i+le][j] == 'G' && ca[i][j-le] == 'G' && ca[i][j+le] == 'G') {
                        m = le;
                        le++;
                        isFound = true;
                    } else {
                        break;
                    }
                }
                if (isFound) {
                    if (m > max1) {
                        pos.clear();
                        max1 = m;
                        pos.add(new int[] {i, j});
                    } else if (m == max1) {
                        pos.add(new int[] {i, j});
                    }
                }
            }
        }
        return max1;
    }
    
    static int twoPlusesLessThan(String[] grid, int maximun) {
        int r = grid.length;
        int c = grid[0].length();
        char[][] ca = new char[r][c];
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            ca[i] = grid[i].toCharArray();
        }
        int max1 = -1;
        int i1 = 0, j1 = 0;
        int max2 = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int le = 0;
                int m = -1;
                boolean isFound = false;
                while (i - le >= 0 && i+le < r && j -le >= 0 && j+le < c && le <= maximun) {
                    if (ca[i-le][j] == 'G' && ca[i+le][j] == 'G' && ca[i][j-le] == 'G' && ca[i][j+le] == 'G') {
                        m = le;
                        le++;
                        isFound = true;
                    } else {
                        break;
                    }
                }
                if (isFound) {
                    if (m > max1) {
                        pos.clear();
                        max1 = m;
                        pos.add(new int[] {i, j});
                    } else if (m == max1) {
                        pos.add(new int[] {i, j});
                    }
                }
            }
        }
        for (int[] p : pos) {
            int temp = -1;
            i1 = p[0];
            j1 = p[1];
            for (int i = 0; i < r; i++) {
                ca[i] = grid[i].toCharArray();
            }
            for (int k = 0; k <= max1;k++) {
                ca[i1+k][j1] = 'B';
                ca[i1-k][j1] = 'B';
                ca[i1][j1-k] = 'B';
                ca[i1][j1+k] = 'B';
            }
            temp = findMaxPlus(ca, new ArrayList<int[]>());
            if (temp > max2) {max2 = temp;}
        }
        return (max1 * 4 + 1) * (max2 * 4 + 1);
        
    }
    
    static int twoPluses(String[] grid) {
        int r = grid.length;
        int c = grid[0].length();
        char[][] ca = new char[r][c];
        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            ca[i] = grid[i].toCharArray();
        }
        int max1 = -1;
        int i1 = 0, j1 = 0;
        int max2 = -1;
        max1 = findMaxPlus(ca, pos);
        for (int[] p : pos) {
            int temp = -1;
            i1 = p[0];
            j1 = p[1];
            for (int i = 0; i < r; i++) {
                ca[i] = grid[i].toCharArray();
            }
            for (int k = 0; k <= max1;k++) {
                ca[i1+k][j1] = 'B';
                ca[i1-k][j1] = 'B';
                ca[i1][j1-k] = 'B';
                ca[i1][j1+k] = 'B';
            }
            temp = findMaxPlus(ca, new ArrayList<int[]>());
            if (temp > max2) {max2 = temp;}
        }
        int pro = (max1 * 4 + 1 ) * (max2 * 4 + 1);
        if (max1 - max2 >= 2) {
            for (int mm = max1 -1; mm > max2; mm--) {
                int o = twoPlusesLessThan(grid, mm);
                if (o > pro) {
                    pro = o;
                }
            }
        }
        return pro;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
