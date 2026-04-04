package com.sirsikar.competitve.knapsack.zeroone;

public class Recursive {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int W = 7;

        System.out.println("Recursive answer is:"+ Knapsack(wt,val,W,wt.length));
    }

    private static int Knapsack(int[] wt, int[] val, int W, int n) {
        if(n ==0 || W == 0) {
            return 0;
        }
        if(wt[n-1] <= W) {
            return Math.max(Knapsack(wt,val,W,n-1),wt[n-1] + Knapsack(wt,val,W-wt[n-1],n-1));
        } else {
            return Knapsack(wt,val,W,n-1);
        }
    }
}
