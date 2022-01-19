import java.io.*; 

public class ques11{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} 

 class Solution{
    public String amendSentence(String s){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(i==0&&ch>=65&&ch<=90){
                int c = ch + 32;
                sb.append((char)c);
                continue;
            }
            
            if(ch>=65&&ch<=90&&i!=0){
                sb.append(" ");
                int c = ch + 32;
                sb.append((char)c);
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
    }
}

