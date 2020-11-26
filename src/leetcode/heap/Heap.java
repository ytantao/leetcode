package leetcode.heap;

public class Heap {
    public static void main(String[] args) {
        int[] data = new int[]{4,1,3,2,16,9,10,14,8,7};
//        for(int i=0;i<data.length;i++){
//            System.out.println(data[i]);
//        }
        Heap heap = new Heap();
        heap.buildHeap(data,data.length);
        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }

    public void buildHeap(int[] data, int heapSize){
        for(int i=heapSize/2-1;i>=0;i--){
            maxHeapify(data,i,heapSize);
        }
    }

    public void maxHeapify(int[] data,int i,int heapSize){
        int largest=i, left=i*2+1, right=i*2+2;
        if(left<heapSize && data[left]> data[largest]){
            largest = left;
        }
        if(right<heapSize && data[right]>data[largest]){
            largest = right;
        }
        if(largest!=i){
            swap(data,i,largest);
            maxHeapify(data,largest,heapSize);
        }
    }

    public void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
