import java.util.Scanner;

/* 
    1 x 1: 8 * 8 = 64 squares.
    2 x 2: 7 * 7 = 49 squares.
    3 x 3: 6 * 6 = 36 squares.
    4 x 4: 5 * 5 = 25 squares.
    5 x 5: 4 * 4 = 16 squares.
    6 x 6: 3 * 3 = 9 squares.
    7 x 7: 2 * 2 = 4 squares.
    8 x 8: 1 * 1 = 1 square.
    
    1^2 + 2^2 + 3^2 + ... + n^2 
    it is a GP so using it's sum property = n(n+1)(2n+1) / 6
*/


public class goldmanprblm_12 {

    public static double findSquares(int n) {
        return (n * (n + 1) / 2) * (2 * n + 1) / 3;


    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();

            System.out.println((int)findSquares(n));
        }

        
    }
}
