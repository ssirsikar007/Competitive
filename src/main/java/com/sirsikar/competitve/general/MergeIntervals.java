package com.sirsikar.competitve.general;

import java.util.*;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = mergeIntervals(intervals);
        for (int[] i : result) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > end) {
                list.add(List.of(start, end));
                start = intervals[i][0];
            }
            end = Math.max(end, intervals[i][1]);
        }
        list.add(List.of(start, end));
        return list.stream()
                .map(innerList -> innerList.stream()
                        .mapToInt(Integer::intValue)
                        .toArray()
                )
                .toArray(int[][]::new);
    }
}
