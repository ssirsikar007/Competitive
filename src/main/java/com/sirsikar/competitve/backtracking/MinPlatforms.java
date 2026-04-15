package com.sirsikar.competitve.backtracking;

import java.util.Arrays;
import java.util.Stack;

public class MinPlatforms {
    public static void main(String[] args) {
            int[] arr = {1000, 935, 1100};
            int[] dep = {1200, 1240, 1130};
            System.out.println(minPlatform(arr, dep));
        }

    private static int minPlatform(int[] arr, int[] dep) {
        int[][] timings = new int[arr.length][2];
        int k=0;
        for (int i = 0; i < arr.length; i++) {
            timings[i][0] = arr[i];
            timings[i][1] = dep[i];
    }
        Arrays.sort(timings, (a,b) -> Integer.compare(a[0],b[0]));
        Stack<Integer> stack = new Stack<>();
        int minPlatform = 0;
        for (int[] time : timings) {
            int a = time[0];
            int d = time[1];
            if(stack.isEmpty()){
                stack.push(d);
            } else {
                while(!stack.isEmpty() && stack.peek() < a){
                    stack.pop();
                }
                stack.push(d);
            }
            minPlatform = Math.max(minPlatform,stack.size());
        }
        return minPlatform;
}
}
