import java.io.*;
import java.util.*;

public class ques3
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.kvowelwords(N,K);
            System.out.println(ans);
        }
    }
}
class Solution{
    int[][] dp = new int[1001][1001]; 
    
    int solve(int N,int K, int cnt){
        if(N==0){
            return -1;
        }
        
        if(dp[N][cnt]!=-1){
            return dp[N][cnt];
        }
        
        if(cnt<K){
            return dp[N][cnt] = (21*solve(N-1,K,0) + 5*solve(N-1,K,cnt+1))%1000000007;
        }
        
        if(cnt==K){
            return dp[N][cnt] = (21*solve(N,K,0))%1000000007;
        }
        
        return -1;
    }
    
    
    public int kvowelwords(int N,int K){
        Arrays.fill(dp,-1);
        return solve(N,K,0)%1000000007; 
        
    }
}
