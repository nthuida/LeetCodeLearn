package com.maomao.test.sort;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 *
 * 示例 2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 *
 * @author huida
 * @date 2020/7/22
 */
public class FindMin {

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int high = nums.length-1;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                //mid是最小值左侧的元素
                low = mid +1;
            } else {
                //mid是最小值右侧的元素，包含当前mid元素
                high = mid;
            }
        }
        return nums[low];
    }
}
