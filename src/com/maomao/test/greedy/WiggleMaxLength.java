package com.maomao.test.greedy;

/**
 * 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 * 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，
 * 第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
 * 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 *
 * 示例 2:
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 *
 * @author huida
 * @date 2020/12/14
 */
public class WiggleMaxLength {

    /**
     * 动态规划
     * 状态定义
     * up[i] 表示以i结尾的最长上升序列的长度
     * down[i] 表示以i结尾的最长下降序列的长度
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] down = new int[len];
        int[] up = new int[len];
        down[0] = 1;
        up[0] = 1;
        for (int i=1; i<len; i++) {
            if (nums[i] > nums[i-1]) {
                //上升序列的长度,可以从 up[i - 1]进行转移，也可以从 down[i−1] 进行转移
                up[i] = Math.max(up[i-1], down[i-1] +1);
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                down[i] = Math.max(down[i-1], up[i-1] +1);
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(up[len-1], down[len-1]);
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int wiggleMaxLengthII(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        //前一对差值
        int preDiff = 0;
        //当前差值
        int curDiff = 0;
        int count = 1;
        for (int i=1; i<len; i++) {
            curDiff = nums[i] - nums[i-1];
            //有峰值，preDiff==0的场景为最开始的那个节点
            if (curDiff>0 && preDiff<=0 || curDiff<0 && preDiff>=0) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
