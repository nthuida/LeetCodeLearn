package com.maomao.test.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author huida
 * @date 2020/6/19
 */
public class SearchRange {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                //收缩右边边界
                high = mid-1;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        //没有找到
        if (low >=nums.length ||nums[low] != target) {
            return -1;
        }
        return low;
    }

    private int searchRight(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                //收缩左边边界
                low = mid+1;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        //没有找到
        if (high < 0 || nums[high] != target) {
            return -1;
        }
        return high;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = new SearchRange().searchRange(nums, 1);
        System.out.println(res);
    }
}
