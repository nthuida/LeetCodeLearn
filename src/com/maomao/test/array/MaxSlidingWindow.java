package com.maomao.test.array;

/**
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * @author huida
 * @date 2020/7/29
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < k || len == 0) {
            return new int[]{};
        }
        int[] res = new int[len-k+1];
        for (int i=0; i<=len-k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j=i; j<i+k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }

        return res;
    }

    public static void main(String[] args) {
       int[]  nums = {1,3,-1,-3,5,3,6,7};
       int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, 3);
        System.out.println(res);
    }
}
