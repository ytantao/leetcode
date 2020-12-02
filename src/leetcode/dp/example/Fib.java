package leetcode.dp.example;

public class Fib {
    public int fib(int n){
        if(n<1){
            return 0;
        }
        int[] memo = new int[n+1];
        return helper(memo,n);
    }
    public int helper(int[] memo, int n){
        if(n==1||n==2){return 1;}
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n] = helper(memo,n-1) + helper(memo,n-2);
        return memo[n];
    }
    public static void main(String[] args) {
        Fib fib1 = new Fib();
        int a = fib1.fib(3);
        System.out.println(a);
    }
}
