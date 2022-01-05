public class goldmanprblm_6 {
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
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
}
