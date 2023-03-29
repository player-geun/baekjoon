package baekjoon.q20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, Integer> wordbook;
    static ArrayList<String> wordList;
    static int N, M;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wordbook = new HashMap<>();
        wordList = new ArrayList<>();

        pushWords();
        changeMapToList();

        Collections.sort(wordList, ((o1, o2) -> {
            if (wordbook.get(o1) == wordbook.get(o2)) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }

                return o2.length() - o1.length();
            }

            return wordbook.get(o2) - wordbook.get(o1);
        }));

        for (String word : wordList) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }

    public static void changeMapToList() {
        wordList.addAll(wordbook.keySet());
    }

    public static void pushWords() throws IOException {
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if(word.length() < M) continue;

            if(wordbook.containsKey(word)) {
                wordbook.put(word, wordbook.get(word) + 1);
            } else {
                wordbook.put(word, 1);
            }
        }
    }
}