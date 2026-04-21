package com.sirsikar.competitve.knapsack.uunbounded;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int sum = 11;

        int[][] dp = new int[coins.length+1][sum+1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if(j==0) {
                    dp[i][j] = 1;
                } else if(i==0) {
                    dp[i][j] = 0;
                } else if(coins[i-1]<=j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                } else  {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("Number of ways: "+dp[coins.length][sum]);
    }
}
