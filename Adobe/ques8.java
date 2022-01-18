import java.util.Scanner;

public class ques8
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
class Solution
{
    
    boolean isDigit(char ch){
        if(ch>=48&&ch<=57){
            return true;
        }else if(ch==45){
            return true;
        }else{
            return false;
        }
    }
    
    int atoi(String str) {
    	for(int i=0;i<str.length();i++){
    	    char ch = str.charAt(i);
    	    
    	    if(isDigit(ch)){
    	        continue;
    	    }else{
    	        return -1;
    	    }
    	}
    	
    	int ans = Integer.parseInt(str);
    	
    	return ans;
    	
    }
}

