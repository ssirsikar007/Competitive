package com.sirsikar.competitve.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println("Longest increasing subsequence:"+ LIS(arr));
    }

    private static int LIS(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=arr.length-1;i>=0;i--){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}
