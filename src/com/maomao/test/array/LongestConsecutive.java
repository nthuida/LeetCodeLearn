package com.maomao.test.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author huida
 * @date 2020/6/9
 */
public class LongestConsecutive {
    /**
     * 1、用哈希表保存数组，查询效率O(1)
     * 2、找到连续子序列的最小开始值
     * 3、遍历更新结果
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        //查询加去重
        Set<Integer> set = new HashSet<>();
        for (int  i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            //找到连续子序列最小开始值
            if (!set.contains(num-1)) {
                int count = 0;
                //从最小值开始向后寻找，这边查找效率为O(1),所以整个复杂度为O(n)
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                //更新最大值
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
