import java.util.*;

public class ques13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] nums = new String[n];
        for(int i=0;i<n;i++){
            nums[i] = scn.nextLine();
        }
        int k = scn.nextInt();

        Solution s = new Solution();

        System.out.println(s.kthLargestNumber(nums, k));


    }
}

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(new StringCompare());
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
    
    class StringCompare implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if(a.length() > b.length()) return 1;  
            else if(a.length() < b.length()) return -1;
            return a.compareTo(b);   
        }
    }
}
