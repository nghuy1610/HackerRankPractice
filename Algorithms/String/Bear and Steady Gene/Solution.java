import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
        int[] count = new int[26];
        int len = gene.length();
        int min = len;
        // Count number of A, C, G, T
        for(int i = 0; i < len; i++) {
            count[gene.charAt(i) - 'A']++;
            
        }
        int mean = len/4;
        // Count number of redundant character
        count['A' - 'A'] -= mean;
        count['C' - 'A'] -= mean;
        count['G' - 'A'] -= mean;
        count['T' - 'A'] -= mean;
        
        if (count[0] == 0 && count[1] == 0 && count[2] == 0 && count[3] == 0) {
            return 0;
        }
        int i = 0, j = 1;
        for (; i < len; i++) {
            char ch = gene.charAt(i);
            //Only start at character with number more than mean
            if (count[ch - 'A'] <= 0) {continue;}
            count[ch - 'A']--;
            // For each character, minus 1 from number of redundant character until
            // there is no redundant character from i to j inclusive.
            for (j=i+1; j < len; j++) {
                if (count['A' - 'A'] <= 0 && count['C' - 'A'] <= 0 && count['G' - 'A'] <= 0 && count['T' - 'A'] <= 0) {
                    j--;break;
                }
                char c = gene.charAt(j);
                count[c - 'A']--;
            }
            min = j-i+1; break;
        }
        // Now i to j include all redundant character but some character is include more than needed
        // Those character is redundant from substrig and has the number < 0.
        
        while (i < len && j < len) {
            char c1 = gene.charAt(i);
            // If c1 is not redundant from substring, find next same character as last one
            //For each traversed character increase its redundancy by minus 1.
            if (count[c1-'A'] == 0) {
                do {
                    j++;
                    if (j >= len) {
                        return min;
                    }
                    count[gene.charAt(j)-'A']--;
                } while(c1 != gene.charAt(j));
            }
            count[c1-'A']++; //Reduce redundancy of first character (it's skipped)
            // For each traversed character if number < 0, reduce redundanct by
            // increase 1.
            // Character at pos that is not redundant is the next starting point.
            for (i = i+1; i <= j; i++) {
                char c = gene.charAt(i);
                if (count[c - 'A'] == 0) {break;}
                else {count[c - 'A']++;}
            }
            int length = j - i + 1;
            if (length < min) {min = length;}
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
