package baekjoon.programmers;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewId {

    public static void main(String[] args) {
        String new_id = "=.=";

        String oneStageId = validateOneStage(new_id);
        String twoStageId = validateTwoStage(oneStageId);
        String thirdStageId = validateThirdStage(twoStageId);
        String fourStageId = validateFourStage(thirdStageId);
        String fiveStageId = validateFiveStage(fourStageId);
        String sixStageId = validateSixStage(fiveStageId);
        String sevenStageId = validateSevenStage(sixStageId);

        System.out.println(sevenStageId);
    }

    public static String validateOneStage(String id) {
        return id.toLowerCase();
    }

    public static String validateTwoStage(String id) {
        char[] arr = id.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i]) || Character.isDigit(arr[i]) ||
                    arr[i] == '-' || arr[i] == '_' || arr[i] == '.') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    public static String validateThirdStage(String id) {
        char[] arr = id.toCharArray();
        StringBuilder sb = new StringBuilder();
        char last = ' ';

        for (int i = 0; i < arr.length; i++) {
            if (last == '.' && arr[i] == '.') {
                continue;
            }
            sb.append(arr[i]);
            last = arr[i];
        }

        return sb.toString();
    }

    public static String validateFourStage(String id) {
        if (id.length() > 2 && id.charAt(0) == '.' && id.charAt(id.length() - 1) == '.') {
            return id.substring(1, id.length() - 1);
        }

        if(id.charAt(0) == '.') {
            return id.substring(1, id.length());
        }

        if (id.charAt(id.length() - 1) == '.') {
            return id.substring(0, id.length() - 1);
        }

        return id;
    }

    public static String validateFiveStage(String id) {
        if (id.isEmpty()) {
            return "a";
        }

        return id;
    }

    public static String validateSixStage(String id) {
        if (id.length() > 15) {
            String temp = id.substring(0, 15);

            if (temp.charAt(14) == '.') {
                return temp.substring(0, 14);
            }

            return temp;
        }

        return id;
    }

    public static String validateSevenStage(String id) {
        while (id.length() < 3) {
            id = id + id.charAt(id.length() - 1);
        }

        return id;
    }
}
