package baekjoon.q1969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String[] codes;
    private static Map<Character, Integer> map;
    private static int N, M, sum;
    private static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        codes = new String[N];

        for (int i = 0; i < N; i++) {
            codes[i] = br.readLine();
        }

        calculateHammingDistance();

        System.out.println(result);
        System.out.println(sum);
    }

    public static void calculateHammingDistance() {
        char ch = ' ';
        int max;
        int hammingDistance = 0;
        for (int i = 0; i < M; i++) {
            map = new HashMap<>();
            max = 0;
            for (int j = 0; j < N; j++) {
                Character key = codes[j].charAt(i);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }

            Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();

            while(it.hasNext()) {
                Map.Entry<Character, Integer> entrySet = (Map.Entry<Character, Integer>)it.next();
                int value = entrySet.getValue();
                char key =  entrySet.getKey();

                if( max < value ) {
                    max = value;
                    ch = key;
                }
                else if(max == value) {
                    char temp = key;

                    int num1 = Character.getNumericValue(ch);
                    int num2 = Character.getNumericValue(temp);

                    if(num1 > num2) {
                        ch = temp;
                    }
                }
            }
            sum += N - max;
            result += ch;
        }
    }
}
