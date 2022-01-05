import java.util.*;

public class goldmanprblm_14{
    
    public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
        int n = scn.nextInt();
        int t = scn.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scn.nextInt();
        }

        int res = minSubArrayLen(t,nums);
        System.out.println(res);
    }
}

public static int minSubArrayLen(int target, int[] nums) {
    int i =0 , j = 0;
    int n = nums.length;
    int min = Integer.MAX_VALUE;
    int currSum = 0;
    
    while(j < n){
        if(j < n && currSum >= target){
            currSum += nums[j++];
        }
        
        while(j < n && currSum < target){
            currSum += nums[j++];
        }
        
        if(currSum >= target){
            
            while(i< j && currSum - nums[i] >= target){
                currSum -= nums[i++];
            }
            
            min = Math.min(min , j- i);
        }
                    
    }
    
    if(min == Integer.MAX_VALUE) return 0;
    
    return min ;
}
    
}
