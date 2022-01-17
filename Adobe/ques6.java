import java.util.*;

public class ques6{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}


class Solution {
    
    public List<String> AllParenthesis(int n){
        
        List<String> res = new ArrayList<>();
        Helper(n,n,"",res);
        return res;
    }
    
    static void Helper(int openB,int closedB, String s,List<String> res){
        if(openB == 0 && closedB == 0){
            res.add(s);
            return;
        }
        else if(openB < 0 || closedB < 0)
        return;
        
        Helper(openB - 1,closedB,s + "(",res);
        if(openB < closedB)
        Helper(openB ,closedB - 1,s + ")",res);
    }
}