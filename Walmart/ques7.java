import java.util.*;
import java.io.*;

public class ques7 {
    public static boolean isSubSequence(ArrayList<Integer> v1, ArrayList<Integer> v2,int n, int m) {

        if (m == 0)
            return true;
        if (n == 0)
            return false;

        if (v1.get(n - 1).equals(v2.get(m - 1)))
            return isSubSequence(v1, v2, n - 1, m - 1);

        return isSubSequence(v1, v2, n - 1, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(str[i]));
            }
            Solution g = new Solution();
            ArrayList<Integer> res = g.find3Numbers(a, n);

            // wrong format output
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            }

            if (res.isEmpty()) {
                System.out.println(0);
            } else if ((res.get(0) < res.get(1)) && (res.get(1) < res.get(2)) &&
                    isSubSequence(a, res, n, res.size())) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
}

class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {

        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr.get(i))
                st.pop();
            st.push(arr.get(i));
            if (st.size() == 3)
                break;
        }
        if (st.size() >= 3) {
            for (int i = 2; i >= 0; i--)
                ans.add(st.pop());
        }
        return ans;

    }
}
