package com.sirsikar.competitve.knapsack.unbounded;

public class RodCutting {

    public static void main(String[] args) {

        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price  = {1, 5, 8, 9, 10, 17, 17, 20};

        int rodLength = 8;
        int n = length.length;

        int[][] dp = new int[n + 1][rodLength + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= rodLength; j++) {

                if (length[i - 1] <= j) {

                    dp[i][j] = Math.max(
                            dp[i - 1][j],                         // exclude piece
                            price[i - 1] + dp[i][j - length[i - 1]] // include again
                    );

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Maximum Profit = " + dp[n][rodLength]);
    }
}