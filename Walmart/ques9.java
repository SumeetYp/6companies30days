import java.util.*;

public class ques9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Solution s = new Solution();

        System.out.println(s.getMoneyAmount(n));

    }
}

class Solution {
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int c = 1; c <= n; c++) {
            for (int i = 1, j = c + 1; i <= n && j <= n; j++, i++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.max(i >= k - 1 ? 0 : dp[i][k - 1], k + 1 >= j ? 0 : dp[k + 1][j]) + k);
                }
            }
        }
        return dp[1][n];
    }
}
