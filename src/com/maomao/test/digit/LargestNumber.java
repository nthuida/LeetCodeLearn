package com.maomao.test.digit;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @author huida
 * @date 2020/9/9
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        //转为字符串比较
        for (int i=0;i<nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        //通过比较(a+b)和(b+a)的大小，就可以判断出a,b两个字符串谁应该在前面
        Arrays.sort(strs, (a, b) -> {
            //返回值大于0，交换a和b
            return (b+a).compareTo(a+b);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        //都是0的情况
        if (stringBuilder.charAt(0) == '0') {
            return "0";
        }
        return stringBuilder.toString();
    }

}
