import java.util.*;
import java.io.*;

public class ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for (int ii = 0; ii < res.size(); ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        int sum = 0;
        int front = 1;
        int rear = 1;
        // Your code here
        for (int a = 1; a <= n; a++) {
            sum += arr[a - 1];
            if (sum == s) {
                break;
            }
            if (sum > s) {
                ++front;
                sum = 0;
                rear = front;
                a = front - 1;
            } else {
                ++rear;
            }
        }

        ArrayList<Integer> a = new ArrayList<>();
        if (rear > n) {
            a.add(-1);
        } else {
            a.add(front);
            a.add(rear);
        }
        return a;
    }
}