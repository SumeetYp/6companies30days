import java.util.*;

public class ques13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i : arr) {
            arr[i] = scn.nextInt();
        }
        Solution s = new Solution();

        System.out.println(s.validMountainArray(arr));

    }
}

class Solution {
    public boolean validMountainArray(int[] arr) {

        if (arr.length < 3)
            return false;// Checking for contraints
        int i = 0, j = arr.length - 1, fl = 0;
        while (i < arr.length - 1 && arr[i] < arr[i + 1])
            i++;
        while (j > 0 && arr[j] < arr[j - 1])
            j--;
        if (i == 0 || j == arr.length - 1)
            return false;// it means that array is sorted
        if (i == j)
            return true;
        return false;
    }
}