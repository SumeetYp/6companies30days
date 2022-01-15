import java.util.*;

public class ques13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();

            Solution ob = new Solution();

            System.out.println(ob.isBridge(V, list, c, d));
        }
    }
}

class Solution {
    static int isBridge(int v, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        boolean[] visited = new boolean[v];
        int[] timeOfInsertion = new int[v];
        int[] lowestTime = new int[v];
        int timer = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (isBridgeFoundAtCD(i, -1, visited, timeOfInsertion, lowestTime, adj, timer, c, d)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    static boolean isBridgeFoundAtCD(int node, int parent, boolean[] visited, int[] timeOfInsertion, int[] lowestTime,
            ArrayList<ArrayList<Integer>> adj, int timer, int c, int d) {
        visited[node] = true;
        timeOfInsertion[node] = lowestTime[node] = timer++;
        ArrayList<Integer> children = adj.get(node);
        for (Integer child : children) {
            if (child == parent) {
                continue;
            }
            if (!visited[child]) {
                if (isBridgeFoundAtCD(child, node, visited, timeOfInsertion, lowestTime, adj, timer, c, d)) {
                    return true;
                }
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[child]);
                if (lowestTime[child] > timeOfInsertion[node]) {
                    if ((child == c && node == d) || (child == d && node == c)) {
                        return true;
                    }
                }
            } else {
                lowestTime[node] = Math.min(lowestTime[node], timeOfInsertion[child]);
            }
        }
        return false;
    }
}
