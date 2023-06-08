package baekjoon.programmers;

public class NumberPresentation {

    public int solution(int n) {
        int count = 0;
        int left = 1;
        int right = 1;

        while(left <= right) {
            int sum = (right + left) * (right - left + 1) / 2;
            if (sum == n) {
                count++;
                left++;
                right++;
            } else if(sum < n) {
                right++;
            } else {
                left++;
            }
        }

        return count;
    }
}
