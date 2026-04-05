package com.sirsikar.competitve.general;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Given:

An array of integers nums
An integer target

👉 Return indices of the two numbers such that:

nums[i] + nums[j] = target
Rules:
Exactly one solution exists
You cannot use the same element twice
Return indices (not values)*/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        List<Integer> indices = twoSum(nums, target);
        if (indices.isEmpty()) {
            System.out.println("No two sum solution");
        } else {
            System.out.println(indices);
        }
    }

    private static List<Integer> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return List.of(map.get(rem), i);
            } else {
                map.put(nums[i], i);
            }
        }
        return List.of();
    }
}
