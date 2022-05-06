package com.maomao.test.slidingWindow;

/**
 * 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 *  示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * @author huida
 * @date 2020/5/19
 */
public class NumberOfSubarrays {

    /**
     * 滑动窗口法
     *
     * 不断右移 right 指针来扩大滑动窗口，使其包含 k 个奇数；
     * 若当前滑动窗口包含了 k 个奇数，则如下「计算当前窗口的优美子数组个数」：
     *
     * 统计第 1 个奇数左边的偶数个数 leftEvenCnt。 这 leftEvenCnt 个偶数都可以作为「优美子数组」的起点，因此起点的选择有 leftEvenCnt + 1 种。
     * 统计第 k 个奇数右边的偶数个数 rightEvenCnt 。 这 rightEvenCnt 个偶数都可以作为「优美子数组」的终点，因此终点的选择有 rightEvenCnt + 1 种。
     * 因此「优美子数组」左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)。
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int oddCount = 0;
        while (right < nums.length) {
            //找到k个奇数的右区间的位置
            if ((nums[right++] % 2) == 1) {
                oddCount++;
            }
            if (oddCount == k) {
                int temp = right;
                while (right < nums.length && (nums[right] % 2) == 0) {
                    right++;
                }
                //第 k 个奇数右边的偶数个数
                int rightEvenCnt = right-temp;

                int leftEvenCnt = 0;
                while ((nums[left] % 2) == 0) {
                    //第 1 个奇数左边的偶数个数
                    leftEvenCnt++;
                    left++;
                }
                //计算符合条件的组合数
                count += (leftEvenCnt + 1) * (rightEvenCnt + 1);

                //滑动
                left++;
                oddCount--;
            }
        }
        return count;
    }

}
