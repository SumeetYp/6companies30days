import java.util.Scanner;

abstract interface MountainArray {
    public int get(int index) {}
    public int length() {}
}

public class ques6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int target = scn.nextInt();
        int[] nums = {1,2,3,4,5,3,1};
        MountainArray marr = new MountainArray();

        Solution s = new Solution();
        int ans = s.findInMountainArray(target, marr);
        System.out.println(ans);
    }
}
 
 
class Solution {
    public int findInMountainArray(int target, MountainArray mArr) {
   
            // find the peak element first and then search left and right
      int peekElement= peek(mArr);
            if(mArr.get(peekElement)==target){ // if peek is target then return as peek as single peek is present 
                
                    return peekElement;
            }
            int  searchedValueInAsc=searchInArray(mArr,target,0,peekElement);
            // if left half gives -1 then only search for right part 
            if(searchedValueInAsc==-1){
                    return searchInArray(mArr,target,peekElement,mArr.length()-1);
            }
            // else return left half's result
            return searchedValueInAsc;
    }
        // below is Order-Agnostic Binary Search which reduces code writing 
        int searchInArray(MountainArray mArr,int target,int start,int end){
                if(mArr.get(start)<mArr.get(end)){
                        //if start is less than end then ascending ordered 
                
                while(start<=end){
                        int mid=start+(end-start)/2;
                        if(mArr.get(mid)==target){
                                return mid;
                        }
                        else if(mArr.get(mid)<target){
                                start=mid+1;
                        }
                        else{
                                end=mid-1;
                        }
                }
                        //if not found element then return -1 indicating no target on left
                return -1;
                }
                // search in the decending part i.e right part of array 
                else{
                        while(start<=end){
                        int mid=start+(end-start)/2;
                        if(mArr.get(mid)==target){
                                return mid;
                        }
                        else if(mArr.get(mid)>target){
                                start=mid+1;
                        }
                        else{
                                end=mid-1;
                        }
                }
                return -1;
                        
                }
        }
        // simple peek finding of the array
       
        int peek(MountainArray mArr){
                int start=0;
                int end=mArr.length()-1;
                while(start<end){
                        int mid=start+(end-start)/2;
                        if(mArr.get(mid)<mArr.get(mid+1)){
                                start=mid+1;
                        }
                        else{
                                end=mid;
                        }
                }
                return start;
        }
}
