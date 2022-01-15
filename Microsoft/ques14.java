import java.io.*;

public class ques14{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}

class Solution{
    static int minSteps(int D){
        if(D == 0 || D == 1)
            return D;
        
        int sum = 0,cnt = 1;
        while(true){
            sum += cnt;
            if(sum == D)
                return cnt;
            if(sum > D && (sum-D) % 2 == 0)
                return cnt;
            cnt++;
        }
    }
}