package leetcode.max_k_215;


//   PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //大顶堆，容量11
//public int compare(Integer i1,Integer i2){
//        return i2-i1;
//        }
//        });

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{4,1,3,2,16,9,10,14,8,7};
        Solution solution = new Solution();
        int top_k_num = solution.topK(data,2);
        System.out.println(top_k_num);
    }
    public int topK(int[] data, int k){
            int heapSize = data.length;
            buildeHeap(data,heapSize);
            //删除k个堆顶元素，类似堆排序
            for(int i=data.length-1;i>=data.length-k+1;i--){
                swap(data,i,0);
                --heapSize;
                buildeHeap(data,heapSize);
        }
            return data[0];
    }

    public void buildeHeap(int[] data, int heapSize){
        for(int i=heapSize/2-1;i>=0;i--){
            maxHeapipy(data,i,heapSize);
        }
    }

    public void maxHeapipy(int[] data, int i, int heapSize){
        int largest=i, left=2*i+1, right=2*i+2;
        if(left<heapSize && data[left]>data[largest]){
            largest=left;
        }
        if(right<heapSize && data[right]>data[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(data,i,largest);
            maxHeapipy(data,largest,heapSize);
        }

    }
    public void swap(int[]data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
