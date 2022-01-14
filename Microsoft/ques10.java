import java.util.*;

public class ques10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            System.out.println(new Solution().FindMaxSum(arr, n));
        }
    }
}

class Solution {
    public int FindMaxSum(int arr[], int n) {

        int[] dp = new int[n];
        if (n == 1)
            return arr[0];
        if (n == 2)
            return Math.max(arr[0], arr[1]);
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[n - 1];
    }
}