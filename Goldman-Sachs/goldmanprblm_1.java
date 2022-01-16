
import java.io.*;
import java.util.*;

class goldmanprblm_1 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	List<String> keyList = new ArrayList<>();
    	Map<String, List<String>> map = new HashMap<>();
    	for(String str: string_list) {
    		char chars[] = str.toCharArray();
    		Arrays.sort(chars);
    		String key = String.valueOf(chars);
			List<String> strList = new ArrayList<>();
    		if(map.containsKey(key)) {
    			strList = map.get(key);
    		}
    		if(!keyList.contains(key)) {
    			keyList.add(key);
    		}
			strList.add(str);
    		map.put(key, strList);
    	}

    	for(String key : keyList) {
    		result.add(map.get(key));
    	}
    	return result;
    }
}
