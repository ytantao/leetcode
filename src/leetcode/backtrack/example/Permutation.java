package leetcode.backtrack.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    List<List<Integer>> res = new ArrayList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutation permutation = new Permutation();
        permutation.permute(nums);
        System.out.println(permutation.res);
    }
    public void backtrack(int[] nums, List<Integer> track){
        if(track.size()==nums.length){

            res.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size()-1);
        }
    }
}

