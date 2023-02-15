package baekjoon.q6550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String str;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);

            String s1 = st.nextToken();
            String s2 = st.nextToken();

            index = 0;

            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(index) == s2.charAt(i)) {
                    index++;
                }

                if (index == s1.length()) {
                    break;
                }
            }

            if (index == s1.length())
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
