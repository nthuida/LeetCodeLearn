package com.maomao.test.greedy;

import java.util.Arrays;

/**
 * K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 *
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 *
 * @author: huida
 * @date: 2022/7/11
 **/
public class LargestSumAfterKNegations {

    /**
     * 第一步：从小到大排序
     * 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
     * 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
     * 第四步：求和
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        //把可能的负数排在从小到大前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            //贪心，如果是负数，而k还有盈余，就把负数反过来
            if (k>0 && nums[i]<0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        //重新排序
        Arrays.sort(nums);
        if (k == 0) {
            //可以转的负数都转了
            return sum;
        } else {
            if (k%2 == 0) {
                //有余，说明负数都转了，k有偶数个，自个抵消，和不变
                return sum;
            } else {
                //有余，奇数个，减去2倍的最小正数
                return sum - 2*nums[0];
            }
        }
    }
}
