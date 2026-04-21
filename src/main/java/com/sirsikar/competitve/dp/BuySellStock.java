package com.sirsikar.competitve.dp;

public class BuySellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max profit: "+ maxProfit(prices));
    }

    public static int maxProfit(int[] arr) {
        int min=0;
        int max = 0;
        int profit = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] < arr[min]) {
                min = i;
            }
            if(arr[i] > arr[max]) {
                max = i;
            }
            if(max<min) {
                max = min;
            }
            profit = Math.max(profit,arr[max] - arr[min]);
        }
        return profit;
    }
}
