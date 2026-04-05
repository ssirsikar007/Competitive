package com.sirsikar.competitve.knapsack.zeroone;

/*Given an array arr[] and an integer diff, count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.

Note: A partition in the array means dividing an array into two subsets say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only one of the subsets.

Examples:



Input: arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: There is only one possible partition of this array. Partition : [6, 4], [5, 2]. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.*/

/*
* S1 + S2 = Sum
* S1 - S2 = Diff
*
* 2S1 = (Sum+Diff)
* S1 =  (Sum+Diff)/2  Basically becomes count od subsetsum
* */

import java.util.Arrays;

public class SubsetWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {5,2,6,4};
        int diff = 3;
        int sum = Arrays.stream(arr).sum();

        int val = (diff + sum) / 2;

        int[][] dp = new int[arr.length+1][val+1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= val; j++) {
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

        System.out.println("Subsets count with given difference is: "+dp[arr.length][val]);
    }
}
