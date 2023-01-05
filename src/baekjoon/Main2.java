

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int sum = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'I') {
                if (i >= line.length() - 1) {
                    sum += 1;
                    break;
                }
                char temp = line.charAt(i + 1);
                if (temp == 'V') {
                    sum += 4;
                    i += 1;
                } else if (temp == 'X') {
                    sum += 9;
                    i += 1;
                } else {
                    sum += 1;
                }
            } else if (c == 'X') {
                if (i >= line.length() - 1) {
                    sum += 10;
                    break;
                }
                char temp = line.charAt(i + 1);
                if (temp == 'L') {
                    sum += 40;
                    i += 1;
                } else if (temp == 'C') {
                    sum += 90;
                    i += 1;
                } else {
                    sum += 10;
                }
            } else if (c == 'V') {
                sum += 5;
            } else if (c == 'L') {
                sum += 50;
            } else if (c == 'C') {
                sum += 100;
            }
        }

        System.out.println(sum);
    }
}
