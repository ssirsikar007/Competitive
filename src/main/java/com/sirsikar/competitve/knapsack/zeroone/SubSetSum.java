package com.sirsikar.competitve.knapsack.zeroone;

/*
* Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum.

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.*/

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        boolean[][] dp = new boolean[arr.length+1][sum+1];
        int n = arr.length;
        for(int i=0;i<=n; i++){
            for(int j=0;j<=sum;j++){
                if(j == 0) {
                    dp[i][j] = true;
                }
                else if(i == 0) {
                    dp[i][j] = false;
                } else if(arr[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else  {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0;i<=n; i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j] ? "T " : "F ");
            }
            System.out.println();
        }


        System.out.println("Is subset with given sum possible:"+ dp[n][sum]);
    }


}
