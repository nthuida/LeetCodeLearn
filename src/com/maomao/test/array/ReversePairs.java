package com.maomao.test.array;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * @author huida
 * @date 2020/5/25
 */
public class ReversePairs {


    /**
     *
     * 利用「归并排序」计算逆序对，是非常经典的做法；
     * 关键在于「合并两个有序数组」的步骤，利用数组的部分有序性，一下子计算出一个数之前或者之后元素的逆序的个数；
     * 前面「分」的时候什么都不做，「合」的过程中计算「逆序对」的个数；
     *「排序」的工作是必要的，正是因为「排序」才能在下一轮利用顺序关系加快逆序数的计算，也能避免重复计算；
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        //不改变原数组
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        return reversePairs(copy, 0, len - 1);
    }

    /**
     * 计算逆序对
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int reversePairs(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        //左边的逆序对
        int leftPairs = reversePairs(nums, left, mid);
        //右边的逆序对
        int rightPairs = reversePairs(nums, mid + 1, right);
        //有序，不需要计算
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        //横跨区间的逆序对
        int crossPairs = mergeAndCount(nums, left, mid, right);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right) {
        int[] temp = new int[nums.length];
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                //左边的数组遍历完
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                //右边遍历完
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                //归并
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                //计算逆序对
                count += (mid - i + 1);
            }
        }
        return count;
    }

}
