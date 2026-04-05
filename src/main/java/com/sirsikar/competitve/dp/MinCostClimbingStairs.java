package com.sirsikar.competitve.dp;

import java.util.Arrays;

/*
* You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.*/
public class MinCostClimbingStairs {
    public static void main(String[] args) {
      int[] cost = {10, 15, 20};

      int[] dp = new int[cost.length+1];

      for ( int i = 0; i < cost.length; i++ ) {
          if( i== 0 ||  i==1) {
              dp[i] = cost[i];
          }
          else {
              dp[i] = Math.min(cost[i]+ dp[i-1], cost[i]+ dp[i-2]);
          }
      }
      System.out.println(Arrays.toString(dp));
    }
}
