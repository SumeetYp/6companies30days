import java.util.*;
import java.io.*;

public class ques2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char[][] board = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}

class Solution {
    public boolean isWordExist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length)
            return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length)
            return false;
        if (board[y][x] != word[i])
            return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x + 1, word, i + 1)
                || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }
}