package baekjoon.q19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int count;
    static String startTime, firstEndTime, secondEndTime;
    static HashMap<String, String> startTimePeople;
    static HashMap<String, String> endTimePeople;
    static HashSet<String> nameSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startTimePeople = new HashMap<>();
        endTimePeople = new HashMap<>();
        nameSet = new HashSet<>();
        startTime = st.nextToken();
        firstEndTime = st.nextToken();
        secondEndTime = st.nextToken();

        String str = null;
        while ((str = br.readLine()) != null) {
            String[] line = str.split(" ");
            String time = line[0];
            String name = line[1];
            nameSet.add(name);
            if (startTime.compareTo(time) >= 0) {
                startTimePeople.put(name, time);
                continue;
            }

            if (firstEndTime.compareTo(time) <= 0 && time.compareTo(secondEndTime) <= 0) {
                endTimePeople.put(name, time);
            }
        }

        for (String name : nameSet) {
            if (startTimePeople.containsKey(name) && endTimePeople.containsKey(name)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
