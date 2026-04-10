package com.sirsikar.competitve.dp;

import java.util.Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println("Max product subarray is:"+ maxProductSubArray(arr));
    }

    private static int maxProductSubArray(int[] arr) {
       int res = Arrays.stream(arr).max().getAsInt();
       int curMin = 1,curMax = 1;
       for (int n : arr) {
           int temp = curMax*n;
           curMax = Math.max(n, Math.max(curMax*n, curMin*n));
           curMin = Math.min(n, Math.min(curMax*n, curMin*n));
           res = Math.max(res, curMax);
       }
       return res;
    }
}
