import java.util.*;

public class ques2{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] piles = new int[n];

        for (int i : piles) {
            piles[i] = scn.nextInt();
        }

        Solution s = new Solution();
        System.out.println(s.stoneGame(piles));

    }
}

class Solution {
    public boolean stoneGame(int[] piles) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = piles.length;
        int alice = 0, bob = 0;
        boolean flag = true;
        
        for (int i=0; i<n; ++i) {
            pq.add(piles[i]);
        }
        
        while (!pq.isEmpty()) {
            if (flag) {
                alice += pq.poll();
                flag = false;
            } else {
                bob += pq.poll();
                flag = true;
            }
        }
        
        return alice > bob;
    }
}