package leetcode.被5整除的前缀_1018;


import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] A = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        List<Boolean> res =  Solution.prefixesDivBy5(A);
        System.out.println(res);
    }
    public static List<Boolean> prefixesDivBy5(int[] A) {
        int len = A.length;
        Boolean[] ans = new Boolean[len];
        int sum = 0;
        for(int i=0;i<len;i++){
            sum = sum*2+A[i];
            if(sum%5==0){
                ans[i]=true;
            }
            else{
                ans[i] = false;
            }
        }
        return Arrays.asList(ans);
    }
}