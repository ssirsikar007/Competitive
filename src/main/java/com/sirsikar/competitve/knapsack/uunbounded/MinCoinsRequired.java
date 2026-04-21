package com.sirsikar.competitve.knapsack.uunbounded;

public class MinCoinsRequired {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int sum = 11;

        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        int INF = Integer.MAX_VALUE - 1;

        // If no coins available, impossible to make positive sum
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = INF;
        }

        // Sum = 0 needs 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(
                            dp[i - 1][j],                 // exclude coin
                            1 + dp[i][j - coins[i - 1]]  // include coin again
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if (dp[n][sum] == INF) {
            System.out.println("Not Possible");
        } else {
            System.out.println("Minimum Coins Required = " + dp[n][sum]);
        }
    }
}