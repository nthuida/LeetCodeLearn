package com.maomao.test.array;

/**
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n^2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * @author huida
 * @date 2020/5/26
 */
public class FindDuplicate {

    /**
     * 二分法
     * 先猜一个数（有效范围 [left, right]里的中间数 mid），然后统计原始数组中小于等于这个中间数的元素的个数 cnt，
     * 如果 cnt 大于等于 mid。根据抽屉原理，重复元素就在区间 [left, mid-1] 里，否则在[mid+1,right]
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            int cnt = 0;
            //统计个数
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                //在右边
                left = mid + 1;
            } else {
                //左边
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {2,4,5,2,3,1,6,7};
        System.out.println(new FindDuplicate().findDuplicate(a));
    }
}
