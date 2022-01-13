import java.io.*;
import java.util.*;
class ques4
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}


class Solution
{
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c){
        // this approach needs to be optimized
        // ArrayList<Integer> list=new ArrayList<>();
        // int top = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
        // int dir = 0;
        
        // while(top<=down&&left<=right){
        //     if(dir==0){
        //         for(int i=left;i<=right;i++){
        //             list.add(matrix[top][i]);
        //         }
        //         top = top+1;
        //     }else if(dir==1){
        //         for(int i=top;i<=down;i++){
        //             list.add(matrix[i][right]);
        //         }
        //         right -= 1;
        //     }else if(dir==2){
        //         for(int i=right; i>=left;i--){
        //             list.add(matrix[down][i]);
        //         }
        //         down -= 1;
        //     }else if(dir==3){
        //         for(int i=down;i>=top;i--){
        //             list.add(matrix[i][left]);
        //         }
        //         left += 1;
        //     }
            
        //     dir = (dir+1)%matrix.length;
        // }
        // return list;
        ArrayList<Integer> list=new ArrayList<>();
        int count=0,i=0,j=0,k=0,l=r-1,E=0;
        while(count<r*c){
            if(j<c-E){
                list.add(matrix[i][j]);
                j++;
                count++;
            }else if(i<r-1-E){
                i++;k=j-1;
                list.add(matrix[i][k]);
                count++;
            }else if(k>E){
                k--;
                list.add(matrix[i][k]);
                count++;
            }else if(l>E+1){
                l--;
                list.add(matrix[l][k]);
                count++;
            }else{
                E++;
                j=E;i=E;l=r-1-E;
            }
        }
        return list; 
    }
}
