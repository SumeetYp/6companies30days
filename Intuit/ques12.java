import java.util.*;

public class ques12 {
    public static void main(String args[]) {
        Scanner scn=  new Scanner(System.in);
        int numCourses = scn.nextInt();
        int k = scn.nextInt();
        int l = scn.nextInt();
        int[][] prerequisites = new int[k][l];

        Solution s = new Solution();
        int[] ans = s.findOrder(numCourses, prerequisites);

        for (int i : ans) {
            System.out.println(ans[i]);
        }

    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for ( int t[]: prerequisites ) {
            ArrayList<Integer> list = adj.getOrDefault(t[1], new ArrayList<Integer>());
            list.add(t[0]);
            adj.put(t[1], list);
            inDegree[t[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<numCourses; i++ ) {
            if ( inDegree[i]==0 ) {
                queue.offer(i);
            }
        }
        if ( queue.isEmpty() ) {
            return new int[] {};
        }
        int[] res = new int[numCourses];
        int k = 0;
        while ( !queue.isEmpty() ) {
            int curr = queue.poll();
            res[k++] = curr;
            if ( adj.containsKey(curr) ) {
                for ( int j: adj.get(curr) ) {
                    inDegree[j]--;
                    if ( inDegree[j]==0 ) {
                        queue.offer(j);
                    }
                }
            }
        }
        return k==numCourses ? res : new int[] {};
    }
}
