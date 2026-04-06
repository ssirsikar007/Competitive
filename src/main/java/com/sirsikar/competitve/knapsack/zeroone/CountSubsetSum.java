package com.sirsikar.competitve.knapsack.zeroone;

/*
Given an array arr[] of length n and an integer target, the task is to find the number of subsets with a sum equal to target.

Examples:

Input: arr[] = [1, 2, 3, 3], target = 6
Output: 3
Explanation: All the possible subsets are [1, 2, 3], [1, 2, 3] and [3, 3]

Input: arr[] = [1, 1, 1, 1], target = 1
Output: 4
Explanation: All the possible subsets are [1], [1], [1] and [1]
* */
public class CountSubsetSum {
    public static void main(String[] args) {
        int[]  arr = {1,2,3,3};
        int sum = 6;

        int[][] dp = new int[arr.length+1][sum+1];

        for(int i=0;i<=arr.length;i++) {
            for(int j=0;j<=sum;j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println("Subset sum is: "+ dp[arr.length][sum]);

    }
}
