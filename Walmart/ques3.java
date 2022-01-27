import java.util.*;

public class ques3{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String colors = scn.nextLine();

        Solution s = new Solution();
        System.out.println(s.winnerOfGame(colors));


    }
}

class Solution {
    public boolean winnerOfGame(String colors) {
        int AlicePossibleMoves = 0, BobPossibleMoves = 0;
        
        
        for(int i = 0; i < colors.length(); i++) {
            int curCount = -2;
            int j = i;
            if(colors.charAt(i) == 'A') {
                while(j < colors.length() && colors.charAt(j) == 'A') {
                    j++;
                    curCount++;
                }
                AlicePossibleMoves += curCount > 0? curCount : 0;
            }
            
            else{
                while(j < colors.length() && colors.charAt(j) == 'B') {
                    j++;
                    curCount++;
                }
                BobPossibleMoves += curCount > 0? curCount : 0;
                
            }
            i += curCount > 0? curCount : 0;
        }
        
        return AlicePossibleMoves > BobPossibleMoves;
    }
}