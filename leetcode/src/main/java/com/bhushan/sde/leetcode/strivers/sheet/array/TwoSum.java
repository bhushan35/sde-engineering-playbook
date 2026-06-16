package com.bhushan.sde.leetcode.strivers.sheet.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers nums and an integer target,
* return indices of the two numbers such that they add up to target.
* Input: nums = [2,7,11,15], target = 9
  Output: [0,1]
  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
* link: https://leetcode.com/problems/two-sum/description/
* */
public class TwoSum {

    // time complexity : O(n^2)
    // space complexity: O(1)
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if(sum == target) {
                    return new int[]{i,j};
                }
            }
        }
        throw  new IllegalArgumentException("Not found target");
    }

    // time complexity : O(n)
    // space complexity: O(1)
    public int[] twoSumBetter(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        while (start<end) {
            int sum = nums[start] + nums[end];
            if(sum == target) {
                return new int[]{start,end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{};
    }


    // time complexity : O(n)
    // space complexity: O(n)
    public int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
             int comp = target - nums[i];
             if(indexMap.containsKey(comp)) {
                 return new int[]{i, indexMap.get(comp)};
             }
             indexMap.put(nums[i], i);
        }
        return new int[]{};
    }
 }
