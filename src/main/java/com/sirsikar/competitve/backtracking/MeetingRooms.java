package com.sirsikar.competitve.backtracking;

//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

//Input: [[0,30],[5,10],[15,20]]
//Output: false

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] arr = {{0,30}, {5,10}, {15,20}};
        System.out.println("Can attend meeting: "+ canAttendAll(arr));
    }

    private static boolean canAttendAll(int[][] arr) {
        Arrays.sort(arr, (a,b) -> {
           return  Integer.compare(a[0],b[0]);
        });
        int highestEndTime = 0;
        for (int[] meet : arr){
            if(meet[0]<highestEndTime){
                return false;
            }
            highestEndTime = Math.max(highestEndTime,meet[1]);
        }
        return true;
    }
}
