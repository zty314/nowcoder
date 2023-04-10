package com.tyty.offer.binarysearch;

public class Offer53 {

    public static int search(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        if (rightBound < leftBound || (rightBound == -1 && leftBound == -1)) {
            return 0;
        }
        return rightBound - leftBound + 1;
    }

    public static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left < 0 || left > nums.length - 1) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public static int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || right > nums.length - 1) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        int search = search(new int[]{5, 7, 7, 8, 8, 10}, 8);

        System.out.println(search);
    }
}
