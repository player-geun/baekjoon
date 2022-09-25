package baekjoon.q5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            //명령 함수 입력받기
            String line = br.readLine();
            int end = line.length();
            String[] fuc = new String[end];

            for (int j = 0; j < end; j++) {
                fuc[j] = line.substring(j, j + 1);
            }

            //숫자 배열 입력받기
            int len = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
            int index = 0;
            int tmp = 0;

            for (int j = 0; j < len; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isError = false;
            boolean isRight = true;

            for (int j = 0; j < end; j++) {
                if (fuc[j].equals("R")) {
                    isRight = !isRight;
                } else {
                    if(isRight) {
                        if(deque.pollFirst() == null) {
                            sb.append("error\n");
                            isError = true;
                            break;
                        }

                    } else {
                        if(deque.pollLast() == null) {
                            sb.append("error\n");
                            isError = true;
                            break;
                        }
                    }
                }
            }


            if (!isError) {
                sb.append('[');

                if(deque.size() > 0) {
                    if(isRight) {
                        sb.append(deque.pollFirst());

                        while(!deque.isEmpty()) {
                            sb.append(',').append(deque.pollFirst());
                        }
                    }
                    else {
                        sb.append(deque.pollLast());

                        while(!deque.isEmpty()) {
                            sb.append(',').append(deque.pollLast());
                        }
                    }
                }

                sb.append(']').append("\n");
            }
        }

        System.out.println(sb);
    }
}
