public class ques1 {
    public static int findMinRec(int arr[], int i,int sumCal,int sumTotal) {
        if (i == 0)
            return Math.abs((sumTotal - sumCal)- sumCal);

        return Math.min(findMinRec(arr, i - 1,sumCal + arr[i - 1],sumTotal),findMinRec(arr, i - 1, sumCal,sumTotal));
    }

    public static int findMin(int arr[], int n) {
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];

        return findMinRec(arr, n, 0, sumTotal);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;
        System.out.print("The minimum difference"+ " between two sets is "+ findMin(arr, n));
    }
}

