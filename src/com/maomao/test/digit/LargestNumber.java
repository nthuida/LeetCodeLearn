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
        for (int i=0;i<nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        //排序, 和大的在前
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        if (stringBuilder.charAt(0) == '0') {
            return "0";
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] str = {"30", "3", "34", "5", "9"};
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        System.out.println(str);
    }
}
