package com.maomao.test.digit;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @author huida
 * @date 2020/6/11
 */
public class FindContinuousSequence {

    /**
     * 滑动窗口,双指针，左闭右开
     * 滑动窗口的重要性质是：窗口的左边界和右边界永远只能向右移动
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int sum = 0;
        int left=1, right=1;
        int end = target/2 + 1;
        List<int[]> res = new ArrayList<>();
        while (left<= end ) {
            if (sum < target) {
                //右边界右滑
                sum += right;
                right++;
            } else if (sum > target){
                //左边界右滑
                sum -= left;
                left++;
            } else {
                int[] temp = new int[right-left];
                for (int i = left; i<right ;i++) {
                    temp[i-left] = i;
                }
                res.add(temp);
                //左边界右滑
                sum -= left;
                left++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] res = new FindContinuousSequence().findContinuousSequence(9);
        System.out.println(res);
    }
}
