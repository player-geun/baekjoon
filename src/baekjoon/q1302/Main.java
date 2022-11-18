package baekjoon.q1302;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            boolean isOk = false;
            for (Node node : list) {
                if (Objects.equals(node.name, word)) {
                    node.cnt++;
                    isOk = true;
                    break;
                }
            }

            if (!isOk) {
                list.add(new Node(word, 1));
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0).name);
    }

    private static class Node implements Comparable<Node>{
        private String name;
        private int cnt;

        Node(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (cnt == o.cnt) {
                return name.compareTo(o.name);
            } else {
                return o.cnt - cnt;
            }
        }
    }
}
