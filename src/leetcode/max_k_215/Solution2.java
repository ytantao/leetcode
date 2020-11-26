package leetcode.max_k_215;

import java.util.PriorityQueue;

public class Solution2 {
    public static void main(String[] args) {
        int[] data = new int[]{4,1,3,2,16,9,10,14,8,7};
        Solution2 solution = new Solution2();
        int top_k_num = solution.findKthLargest(data,2);
        System.out.println(top_k_num);
    }
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(minHeap.size()<k){
                minHeap.add(nums[i]);
            }
            else if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
