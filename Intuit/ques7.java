import java.util.*;

public class ques7 {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] weights = new int[n];

        for(int i=0;i<n;i++){
            weights[i] = scn.nextInt();
        }
        
        int days = scn.nextInt();
        Solution s = new Solution();
        System.out.println(s.shipWithinDays(weights, days));
    }
}

class Solution {
    private static boolean transferredInExactDdays(int[] weights, int mid, int days) {
        int idx = 0;
        int totalWeight = 0;
        int daysDone = 1;       
        
        while(idx < weights.length) {
            totalWeight += weights[idx];
            if(totalWeight > mid) {
                totalWeight = weights[idx];     
                daysDone++;                     
                if(daysDone > days) {
                    return false;
                }
            }
            idx++;
        }
        
        return true;
    }
    

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while(left < right) {
            int mid = left + (right-left)/2;
            if(transferredInExactDdays(weights, mid, days)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
