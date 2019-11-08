package com.maomao.test.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 第三大数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * @Author huida.mao
 * @Date 2019/11/8
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax  = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            //计算不重复的数,相同不算
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }
        if (set.size() < 3 ){
            return max;
        } else {
            return thirdMax;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-2147483648};
        System.out.println(new ThirdMax().thirdMax(nums));
    }
}
