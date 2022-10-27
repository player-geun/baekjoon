package baekjoon.q1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] doc = new char[2500];
        char[] word = new char[50];
        int cnt;
        int result = 0;
        int index;

        String temp = br.readLine();
        doc = temp.toCharArray();
        temp = br.readLine();
        word = temp.toCharArray();

        for (int i = 0; i < doc.length; i++) {
            cnt = 0;
            index = i;

            for (int j = 0; j < word.length; j++) {
                if (index >= doc.length) {
                    break;
                }
                if (doc[index] != word[j]) {
                    break;
                }
                index ++;
                cnt++;
            }

            if (cnt == word.length) {
                i = i + word.length - 1;
                result++;
            }
        }

        System.out.println(result);
    }
}
