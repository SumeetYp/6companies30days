import java.util.*;

class ques6
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); 
            int arr[] = new int[n]; 
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}


class Solution
{
static String[] codes = {"0","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static ArrayList<String> possibleWords(int a[], int n){
       ArrayList<String> ans = new ArrayList<>();
        if(n == 0)
            return ans;
        int index = 0;
        String output = "";
        String keypad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(a,n,index,keypad,output,ans);
        return ans;
    }
    
    static void solve(int arr[],int n,int index,String keypad[],String output,ArrayList<String> ans){
    
        if(index >= n){
            ans.add(output);
            return ;
        }
        
        String temp = keypad[arr[index]];
        
        for(int i=0;i<temp.length();i++){
            char ch = temp.charAt(i);
            solve(arr,n,index+1,keypad,output+ch,ans);
            
        }
    }
}


