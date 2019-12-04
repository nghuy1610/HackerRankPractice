import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        boolean isNum = false;
        boolean isLow = false;
        boolean isSpecial = false;
        boolean isUp = false;
        int count = 0;
        int i = 0;
        while ((!isNum && !isLow && !isSpecial && !isUp) || i < n) {
            char c = password.charAt(i);
            if (!isNum && numbers.indexOf(c) != -1) {isNum = true;}
            if (!isLow && lower_case.indexOf(c) != -1) {isLow = true;}
            if (!isUp && upper_case.indexOf(c) != -1) {isUp = true;}
            if (!isSpecial && special_characters.indexOf(c) != -1) {isSpecial = true;}
            i++;
        } 
        if (!isNum) {count++;}
        if (!isLow) {count++;}
        if (!isUp) {count++;}
        if (!isSpecial) {count++;}
        count = count >= 6 - password.length()? count : 6 - password.length();
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
