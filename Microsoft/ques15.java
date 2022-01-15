import java.util.*;

public class ques15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++)
                temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {

                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0; i < Math.min(a.length(), b.length())
                            && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }

                    if (index1 < index2)
                        return 1;
                    else
                        return 0;

                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }

}


class Solution {
    public String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                //System.out.println(s1.charAt(i));
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                }
            }
        }
        int indegree[] = new int[K];
        char res[] = new char[K];
        for (int i = 0; i < adj.size(); i++) {
            for (int x : adj.get(i)) {
                indegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            res[count++] = (char) (u + 'a');
            for (int x : adj.get(u)) {
                if (--indegree[x] == 0)
                    q.add(x);
            }
        }
        String ans = "";
        for (int i = 0; i < K; i++) {
            ans += res[i];
        }
        return ans;
    }
}