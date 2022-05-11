package com.maomao.test.slidingWindow;

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
     * 滑动窗口,左闭右开
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        //窗口的和
        int sum = 0;
        int left=1, right=1;
        List<int[]> res = new ArrayList<>();
        while (right <= target/2+1 ) {
            sum += right;
            //右边界右移
            right++;
            //判断左边界是否收缩
            while (sum > target) {
                sum -= left;
                left++;
            }
            //满足条件
            if (sum == target && (right-left)>=2) {
                int[] temp = new int[right-left];
                for (int i = left; i<right ;i++) {
                    temp[i-left] = i;
                }
                res.add(temp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
