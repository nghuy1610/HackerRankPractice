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

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        int day = 256, month = 0;
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] lmonths = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] smonths = {31, 15, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year < 1918) {
            if (year % 4 == 0) {
                for (int i = 0; i < 12; i++) {
                    if (day > lmonths[i]) {
                        day -= lmonths[i];
                    } else {
                        month = i + 1;
                        break;
                    }
                }
                return String.format("%02d.%02d.%d", day, month, year);
            } else {
                for (int i = 0; i < 12; i++) {
                    if (day > months[i]) {
                        day -= months[i];
                    } else {
                        month = i + 1;
                        break;
                    }
                }
                return String.format("%02d.%02d.%d", day, month, year);
            }
        } else if (year == 1918) {
            for (int i = 0; i < 12; i++) {
                if (day > smonths[i]) {
                    day -= smonths[i];
                } else {
                    month = i + 1;
                    if (month == 2) {
                        day += 13;
                    }
                    break;
                }
            }
            return String.format("%02d.%02d.%d", day, month, year);
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                for (int i = 0; i < 12; i++) {
                    if (day > lmonths[i]) {
                        day -= lmonths[i];
                    } else {
                        month = i + 1;
                        break;
                    }
                }
                return String.format("%02d.%02d.%d", day, month, year);
            } else {
                for (int i = 0; i < 12; i++) {
                    if (day > months[i]) {
                        day -= months[i];
                    } else {
                        month = i + 1;
                        break;
                    }
                }
                return String.format("%02d.%02d.%d", day, month, year);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
