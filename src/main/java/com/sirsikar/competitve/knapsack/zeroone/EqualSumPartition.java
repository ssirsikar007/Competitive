package com.sirsikar.competitve.knapsack.zeroone;

/*
* Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].*/

import java.util.Arrays;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int n = arr.length;

        int sum = Arrays.stream(arr).sum();

        if(sum%2!=0){
            System.out.println("Not possible");
        } else {
            boolean isPossible = subSetSum(arr,sum/2);
            System.out.println(isPossible? "Possible":"Not possible");
        }
    }

    public static boolean subSetSum(int[] arr, int sum){
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        for(int i=0;i<=arr.length; i++){
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
        return dp[arr.length][sum];
    }
}
