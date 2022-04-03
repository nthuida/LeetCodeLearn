package com.maomao.test.search;

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
            int mid = low + (high - low) / 2;
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

    /**
     * 搜索左边界
     * @param nums
     * @param target
     * @return
     */
    public int searchLeft(int[] nums, int target) {
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
        //没有找到，{1,2,3} target=4,左边界会出界
        if (low >=nums.length || nums[low] != target ) {
            return -1;
        }
        return low;
    }

    public int searchRight(int[] nums, int target) {
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
        //{1,2,3}, target = 0,右边界会出界
        if (high < 0 || nums[high] != target) {
            return -1;
        }
        return high;
    }



    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * 你可以假设数组中不存在重复的元素。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     *
     * 示例 2:
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     * 思路：二分查找
     * 1 2 3 4 5 6 7 可以大致分为两类，
     * 第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
     * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
     * 第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
     * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int high = nums.length-1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                //前半部分有序
                if (target >= nums[low] && target < nums[mid]) {
                    //target在前半部分
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //后半部分有序
                if (target <= nums[high] && target > nums[mid]) {
                    //target在后半部分
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     *  搜索旋转排序数组 II
     *  假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *   ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     *  编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     *
     *  示例 1:
     *
     *  输入: nums = [2,5,6,0,0,1,2], target = 0
     *  输出: true
     *  示例 2:
     *
     *  输入: nums = [2,5,6,0,0,1,2], target = 3
     *  输出: false
     * @param nums
     * @param target
     * @return
     */
    public boolean searchII(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int high = nums.length-1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low)/2;
            if (nums[mid] == target) {
                return true;
            }
            //针对有重复项的[1,3,1,1,1]
            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }

            if (nums[low] < nums[mid]) {
                //前半部分有序
                if (target >= nums[low] && target < nums[mid]) {
                    //target在前半部分
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //后半部分有序
                if (target <= nums[high] && target > nums[mid]) {
                    //target在后半部分
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {-1};
        System.out.println(new Search().search1(a, -1));
    }
}
