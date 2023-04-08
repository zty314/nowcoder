package com.tyty.offer.array;

public class OfferII006 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < numbers.length && right >= 0 && left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left, right};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
