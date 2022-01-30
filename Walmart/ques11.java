import java.util.*;

public class ques11{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] speed = new int[n];

        for(int i: speed){
            speed[i] = scn.nextInt();
        }

        int[] efficiency = new int[n];

        for(int i: efficiency){
            efficiency[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        Solution s = new Solution();

        System.out.println(s.maxPerformance(n,speed,efficiency,k));

    }
}

class Solution {
     public class Engineer {
        int speed;
        int efficiency;
        
        Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        List<Engineer> engineers = new ArrayList<Engineer>();
        
        for (int i = 0; i< n ; i++) {
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        // decreasing order
        engineers.sort((a,b)-> b.efficiency - a.efficiency);
        
        //minHeap
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((a,b)-> a.speed- b.speed);
        
        long teamSpeed = 0; // careful with the data types
        long maxPerformance = 0;
        
        for (Engineer newHire: engineers) {
            
            if (currentTeam.size() == k) {
                Engineer slowGuy = currentTeam.poll();
                
                teamSpeed = teamSpeed - slowGuy.speed;
            }
            currentTeam.add(newHire);
            teamSpeed+= newHire.speed;
            
            long performanceWithNewGuy = teamSpeed * (long) newHire.efficiency;
            maxPerformance = Math.max(maxPerformance , performanceWithNewGuy);
        }
        return (int) (maxPerformance % 1000000007);
    }
}