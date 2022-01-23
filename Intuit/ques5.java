import java.util.*;

public class ques5 {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scn.nextInt();
        }

        int m = scn.nextInt();

        Solution s = new Solution();
        int ans = s.splitArray(nums, m);
        System.out.println(ans);
    }    
}


class Solution {
    int min = Integer.MAX_VALUE;
    int M=0;
    int N=0;
    int sums[] = new int[0];
    int[][] cache = new int[1][1];
        
    public int splitArray(int[] nums, int m) {
        M = m;
        N = nums.length;
        cache = new int[N+1][N+1];
        for (int i=0; i<N+1; i++) {
            for (int j=0; j<M+1; j++) {
                cache[i][j] = Integer.MAX_VALUE;
            }
        }
        sums = new int[nums.length+1];
        sums[0] = 0;
        for (int i=0; i<nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        bkt(1, 1, 0);
        return min;
    }
    
    private void bkt(int start, int arrNum, int sum) {
        if (start > N || cache[start][arrNum] <= sum) {
            return;
        }
        if (arrNum == M) {
            sum = Math.max(sum, sums[N] - sums[start-1]);
            min = Math.min(min, sum);
            return;
        }
        for (int i = start; i<N && sums[i]-sums[start-1] < min; i++) {
            int nextSum = Math.max(sum, sums[i]-sums[start-1]);
            if (nextSum < min) {
                bkt(i+1, arrNum+1, nextSum);
            }
        }
        cache[start][arrNum] = sum;
    }
}