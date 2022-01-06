import java.util.*;
public class ques3 {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = Solution.max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&arr[q.getLast()]<=arr[i]){
                System.out.println(i+" th get last "+ q.getLast());
                System.out.println();
                q.removeLast();
            }
            q.addLast(i);
            if(q.getFirst()==i-k){
                System.out.println(i+" th get first i==k condition "+ q.getFirst());
                System.out.println();
                q.removeFirst();
            }
            if(i>=k-1){
                System.out.println(i+" th get first " + (k-1) + q.getFirst());
                System.out.println();
                ans.add(arr[q.getFirst()]);
            }
            System.out.println(ans);
            System.out.println();

        }
      return ans;
    }
}
