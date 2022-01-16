import java.io.*;
import java.util.*;

public class ques2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}

class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        HashMap<Integer,Integer>[]dp = new HashMap[n];
        int ans  = Integer.MIN_VALUE;
        
        for(int i=0; i<A.length;i++){
            
            dp[i] = new HashMap<Integer,Integer>();
            
            for(int j=0; j<i;j++){
                
                int diff = A[i]-A[j];
                
                dp[i].put(diff, dp[j].getOrDefault(diff,1)+1);
                
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans==Integer.MIN_VALUE?1: ans;
        
    }
}
