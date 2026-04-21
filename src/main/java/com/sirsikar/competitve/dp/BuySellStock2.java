package com.sirsikar.competitve.dp;

public class BuySellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] arr) {
        int profit = 0;
        for(int i=1;i<arr.length;i++) {
            if(arr[i] > arr[i-1]) {
             profit += arr[i] - arr[i-1];
            }
        }
        return profit;
    }
}
