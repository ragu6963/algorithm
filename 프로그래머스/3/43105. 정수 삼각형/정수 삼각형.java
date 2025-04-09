import java.util.*;

class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            for (int j = 1; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(triangle[i][j] + dp[i - 1][j],
                    triangle[i][j] + dp[i - 1][j - 1]);
            }
        }

        return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
    }
}