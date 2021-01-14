package leetcode.backtrack.example;

import java.util.LinkedList;
import java.util.List;

public class queen {
    /**
     * N 皇后问题
     */
    private List<List<Integer>> ret = new LinkedList<>();

    public static void main(String[] args) {
        queen queen = new queen();
        List<List<Integer>> ret1 = queen.queen(4);
        System.out.println(ret1);
        System.out.println(ret1.size());
    }
    public List<List<Integer>> queen(int n){
        int[][] trace = new int[n][n];
        backtrace(0, trace);
        return ret;
    }
    public void backtrace(int row, int[][] trace){
        if(row == trace.length){
            List<Integer> path = new LinkedList<>();
            for(int i=0;i<trace.length;i++){
                for(int j=0;j<trace.length;j++){
                    if(trace[i][j]==1){
                        path.add(j);
                    }
                }
            }
            ret.add(path);
            return;
        }
        int n = trace[row].length;
        for(int col=0;col<n;col++){
            if(!isValid(trace,row,col)){
                continue;
            }
            trace[row][col] = 1;
            backtrace(row+1,trace);
            trace[row][col] = 0;
        }
    }
    public boolean isValid(int[][] traces,int row, int col) {
        for (int i = 0; i<row; i++) {
            // 同列
            if(traces[i][col] == 1){
                return false;
            }
        }

        // 左下
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(traces[i][j]==1){
                return false;
            }
        }
        // 右下
        for(int i=row-1,j=col+1;i>=0&&j<traces.length;i--,j++){
            if(traces[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
