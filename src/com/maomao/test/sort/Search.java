package com.maomao.test.sort;

/**
 * 二分法
 * @author Administrator
 * @date 2019/3/14
 */
public class Search {
    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-1};
        System.out.println(new Search().search(a, -1));
    }
}
