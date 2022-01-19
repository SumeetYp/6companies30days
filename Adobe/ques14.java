import java.util.*;
import java.io.*;

public class ques14 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int range[];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            }
            range = new Solution().findSmallestRange(arr, n, k);
            System.out.println(range[0] + " " + range[1]);
        }
    }
}


class Solution {
    class Element implements Comparable<Element> {
        int val;
        int ind;
        int row;

        Element(int val, int ind, int row) {
            this.val = val;
            this.ind = ind;
            this.row = row;
        }

        public int compareTo(Element e) {
            return this.val - e.val;
        }
    }

    int[] findSmallestRange(int[][] KSortedArray, int n, int k) {
        int length = Integer.MAX_VALUE, low = Integer.MAX_VALUE, high = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            max = Math.max(max, KSortedArray[i][0]);
            pq.add(new Element(KSortedArray[i][0], 0, i));
        }
        length = max - pq.peek().val;
        low = pq.peek().val;
        high = max;
        boolean flag = true;
        while (flag) {
            Element x = pq.poll();
            int row = x.row;
            int ind = x.ind;
            if (!(ind + 1 < n)) {
                flag = false;
                break;
            } else {
                Element ne = new Element(KSortedArray[row][ind + 1], ind + 1, row);
                pq.add(ne);
                max = Math.max(max, KSortedArray[row][ind + 1]);
                if (length > max - pq.peek().val) {
                    length = max - pq.peek().val;
                    low = pq.peek().val;
                    high = max;
                }
            }
        }
        int arr[] = { low, high };
        return arr;
    }
}