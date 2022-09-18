package baekjoon.q1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] pos = new String[line.length()];
        int num = 0;
        int start = 0;

        for (int i = 0; i < line.length(); i++) {
            pos[i] = line.substring(i, i + 1);

            if (pos[i].equals(".")) {
                if (num % 2 == 1) {
                    System.out.println(-1);
                    return;
                } else {
                    if (num % 4 == 0) {
                        while (num-- > 0) {
                            pos[start++] = "A";
                        }
                    } else if (num % 4 == 2 && num != 2) {
                        while (num-- > 0) {
                            if (i - start == 2) {
                                pos[i - 1] = "B";
                                pos[i - 2] = "B";
                                break;
                            }
                            pos[start++] = "A";
                        }
                    } else {
                        pos[i - 1] = "B";
                        pos[i - 2] = "B";
                    }
                }
                num = 0;
            } else if (pos[i].equals("X")) {
                if (i != 0 && pos[i - 1].equals(".")) {
                    start = i;
                }
                num++;
            }
        }

        if (num % 2 == 1) {
            System.out.println(-1);
            return;
        }

        if (pos[line.length() - 1].equals("X")) {
            if (num % 4 == 0) {
                while (num-- > 0) {
                    pos[start++] = "A";
                }
            } else if (num % 4 == 2 && num != 2) {
                while (num-- > 0) {
                    if (line.length() - start == 2) {
                        pos[line.length() - 1] = "B";
                        pos[line.length() - 2] = "B";
                        break;
                    }
                    pos[start++] = "A";
                }
            } else {
                pos[line.length() - 1] = "B";
                pos[line.length() - 2] = "B";
            }
        }

        for (String a : pos) {
            System.out.print(a);
        }
    }
}
