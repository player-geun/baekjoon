package baekjoon.programmers;

public class NumberString {

    public static void main(String[] args) {
        String s = "one4seveneight";
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(Character.isDigit(arr[i])) sb.append(arr[i]);

            if (arr[i] == 'z') {
                sb.append(0);
                i += 3;
            }

            if(arr[i] == 'o') {
                sb.append(1);
                i += 2;
            }

            if(arr[i] == 'e') {
                sb.append(8);
                i += 4;
            }

            if(arr[i] == 'n') {
                sb.append(9);
                i += 3;
            }

            if(arr[i] == 't') {
                if (arr[i + 1] == 'w') {
                    sb.append(2);
                    i += 2;
                } else {
                    sb.append(3);
                    i += 4;
                }
            }

            if (arr[i] == 'f') {
                if (arr[i + 1] == 'o') {
                    sb.append(4);
                    i += 3;
                } else {
                    sb.append(5);
                    i += 3;
                }
            }

            if (arr[i] == 's') {
                if (arr[i + 1] == 'i') {
                    sb.append(6);
                    i += 2;
                } else {
                    sb.append(7);
                    i += 4;
                }
            }
        }
    }
}
