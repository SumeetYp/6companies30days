import java.io.*;
import java.util.*;
public class ques4 {
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}

class Solution{
    static String ans="";
    public static String findMaximumNum(String str, int k){
       ans=str;
       maxima(str.toCharArray(),k,0);
       return ans;
    }

    public static void maxima(char[] str,int k,int idx){
        if(k==0||idx==str.length){
            String sp=new String(str);
            if(ans.compareTo(sp)<0){
                ans=sp;
            }
            return;
        }
        char max=str[idx];
        for(int i=idx+1;i< str.length;i++){
            if(str[i]>max){
                max=str[i];
            }
        }
        if(max!=str[idx]){
            k--;
        }

        for(int i=idx;i<=str.length-1;i++){
            if(str[i]==max){
                swap(str,idx,i);
                maxima(str,k,idx+1);
                swap(str,i,idx);
            }
        }
   }
    public static void swap(char []s,int i,int j){
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
        return;
    }
}
