// { Driver Code Starts
import java.util.*;
 
class goldmanprblm_4
{
   public static void main(String[] args) 
   {
 
      try (Scanner sc = new Scanner(System.in)) {
        int T = sc.nextInt();
          sc.nextLine();
          while(T>0)
          {
        	  
        	String str = sc.nextLine();
        	
        	GfG g = new GfG();
        	System.out.println(g.encode(str));
        	
          
            T--;
          }
    }
   }
}

// } Driver Code Ends


class GfG{
	String encode(String str)
	{
          String msi = "";
          
          int count =1;
          int i;
          
          for( i =0 ; i<str.length()-1 ; i++)
          {
              if(str.charAt(i) == str.charAt(i+1))
              count++;
              
              else if(str.charAt(i)!=str.charAt(i+1))
              {
                  msi = msi + str.charAt(i) + count;
                  count =1;
              }
              
         }
          
          msi = msi + str.charAt(i) + count;
          return msi;
	}
	
 }