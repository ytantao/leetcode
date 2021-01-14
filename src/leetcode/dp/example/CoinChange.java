package leetcode.dp.example;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int res = CoinChange.coinChange(coins, 6);
        System.out.println(res);
    }
    public static int coinChange(int[] coins, int amount){
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i=0;i<dp.length;i++){
            for(int coin:coins){
                if(i-coin<0) continue;
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}
