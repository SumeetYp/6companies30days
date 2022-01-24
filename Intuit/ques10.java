import java.util.*;

public class ques10{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] isConnected = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                isConnected[i][j] = scn.nextInt();
            }
        }
        int ans = Solution.findCircleNum(isConnected);

    }
}

class Solution {
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                findCircleNumHelper(isConnected, i, visited);
                count++;
            }
        }
        
        return count;
    }
    
    public static void findCircleNumHelper(int[][] isConnected, int i, boolean[] visited) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                findCircleNumHelper(isConnected, j, visited);
            }
        }
    }
}