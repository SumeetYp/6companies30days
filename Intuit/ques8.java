import java.util.HashMap;
import java.util.Scanner;

public class ques8 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] points = new int[n][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++) points[i][j] = scn.nextInt();
        }

        Solution s = new Solution();
        System.out.println(s.numberOfBoomerangs(points));

    }
}

class Solution {
    public int numberOfBoomerangs(int[][] points) {
       
       HashMap<Integer, Integer> hm = new HashMap<>();
       int boomCount = 0;

       for(int i = 0; i < points.length; i++ ){
       
           for(int j = 0; j < points.length; j++ ){
               if (i == j) continue;
               int dist = getDist(points[i], points[j]);
               hm.put(dist, hm.getOrDefault(dist,0) + 1);
           }
           
           for(Integer key: hm.keySet()){
               int size = hm.get(key);
               if(size >= 2) boomCount += size*(size-1);
           }
           
           hm.clear();
       }
       
       return boomCount;
   }
   
   private int getDist(int[] p1, int[] p2){
       int a = p1[0] - p2[0];
       int b = p1[1] - p2[1];
       
       return a*a + b*b;
   }
}
