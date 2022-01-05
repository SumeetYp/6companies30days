import java.util.Scanner;

public class goldmanprblm_6 {

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String str1 = scn.nextLine();
            String str2 = scn.nextLine();

            String res = Solution.gcdOfStrings(str1,str2);

            System.out.println(res);
        }

    }

}
    class Solution {
        public static String gcdOfStrings(String str1, String str2) {
            int size1 = str1.length();
            int size2 = str2.length();
            if(size2>size1)  return gcdOfStrings(str2,str1);
            if(size1 == size2){
                if(str1.equals(str2)) return str1;
                else return "";
            }
            if(str1.startsWith(str2)){
                return gcdOfStrings(str1.substring(str2.length()),str2);
            }
            
            return "";
        }
}
