import java.io.*;
import java.util.*;

public class ques5{
	public static void main (String[] args) {
	    
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}

class Solution
{
    public static int NumberOfPath(int a, int b) {
        int dp[][]=new int[a][b];
        for(int i=0;i<a;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<b;i++){
            dp[0][i]=1;
        }
        
        for(int i=1;i<a;i++){
            for(int j=1;j<b;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[a-1][b-1];
    }
}