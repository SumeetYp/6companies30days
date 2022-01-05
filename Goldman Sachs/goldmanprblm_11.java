import java.util.Arrays;
import java.util.Scanner;

public class goldmanprblm_11 {

    public static int[] find(int[] arr) {
        int[] res = new int[2];
        Arrays.sort(arr);

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=i+1){
                res[1] = i+1;
            }
            if(arr[i]==arr[i+1]){
                res[0] = arr[i];
            }
        }    

        return res;
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int[] res = find(arr);
        System.out.println(res[0] +  " "+ res[1]);


    }
}
