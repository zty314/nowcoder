package com.example.leetcode.array;

public class LC283 {

    public void moveZeroes(int[] nums) {
        int length = removeElement(nums, 0);
        for (int i = length; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow;
    }
}
