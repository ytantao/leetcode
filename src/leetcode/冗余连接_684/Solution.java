package leetcode.冗余连接_684;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        Solution solution = new Solution();
        int[] res = solution.findRedundantConnection(edges);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
        public int[] findRedundantConnection(int[][] edges) {
            int nodes=edges.length;
            int[] parent = new int[nodes+1];
            int[] rank = new int[nodes+1];
            for(int i=1;i<=nodes;i++){
                parent[i] = i;
                rank[i] = 1;
            }
            for(int i=0;i<edges.length;i++){
                int x_root = find_root(edges[i][0], parent);
                int y_root = find_root(edges[i][1], parent);
                if(x_root==y_root){
                    return edges[i];
                }else{
                    join(x_root,y_root,parent,rank);
                }
            }
            return new int[0];
        }
        public int find_root(int x, int[] parent){
            while(parent[x]!=x){
                x=parent[x];
            }
            return x;
        }
        public void join(int x_root, int y_root, int[] parent, int[] rank){
            if(rank[x_root]>rank[y_root]){
                parent[y_root] = x_root;
            }else if(rank[y_root]>rank[x_root]){
                parent[x_root] = y_root;
            }else{
                parent[y_root]=x_root;
                rank[x_root]++;
            }
        }
}
