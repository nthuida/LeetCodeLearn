package com.maomao.test.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * @author huida
 * @date 2020/7/1
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int first = 1;
        while (true) {
            if (set.contains(first)) {
                first++;
            } else {
                break;
            }
        }
        return first;
    }
}
