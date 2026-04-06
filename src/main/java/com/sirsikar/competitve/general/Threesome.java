package com.sirsikar.competitve.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
* */
public class Threesome {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSome(nums);
        System.out.println("Triplets are:"+ list.toString());
    }

    private static List<List<Integer>> threeSome(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            //skip dups
            if(i >0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if( sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    //skip dups
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                } else if(sum < 0) {
                    left++;
                } else  {
                    right--;
                }
            }
        }

        return  result;
    }
}
