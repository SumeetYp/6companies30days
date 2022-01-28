import java.io.*;
import java.util.*;
public class ques6 {
    
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    N=sc.nextInt();
		    int R=0;
		    R=(int)rev(N);
	
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


class Solution{
    
    int mod = 1000000007; 
       
    long power(int N,int R){
        return Recursive(N,R)%1000000007;
    }
    
    long Recursive(int N, int R){
        if(R == 0)
            return 1;
            
        long result = power(N,R/2);
        result = (result*result)%1000000007;
        if(R%2 == 0)
            return result;
        else
            return result*N;
    }

}
