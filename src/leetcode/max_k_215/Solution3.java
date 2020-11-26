package leetcode.max_k_215;

import java.util.Vector;

public class Solution3 {
    private Vector<Integer> v;  //存储最小堆

    public void push(int x){
//        添加元素
        v.add(x);
        fix_up();
    }
    public void update(int x){
        //替换顶元素并下沉
        v.set(0,x);
        fix_down();
    }
    public int top(){
        return v.get(0);
    }
    public void fix_up(){
        int i = v.size()-1; //最后一个节点坐标
        int p;   //父节点坐标
        while((p=(i-1)>>2)>=0){
            if(v.get(i)>=v.get(p)) break;
            int temp=v.get(i);
            v.set(i,v.get(p));
            v.set(p,temp);
            i = p;
        }
    }
    public void fix_down(){
        int i = 0;
        int left,right,swap;
        while((left=2*i+1)<v.size()){
            swap = (left+1)<v.size() && v.get(left)<v.get(left+1)? left+1:left;
            if(v.get(i)<=v.get(swap)) break;
            int temp=v.get(i);
            v.set(i,v.get(swap));
            v.set(swap,temp);
            i = swap;
        }

    }
}
