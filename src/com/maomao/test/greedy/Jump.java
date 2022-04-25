package com.maomao.test.greedy;

/**
 * 跳跃游戏II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * @Author huida.mao
 * @Date 2020/05/07
 */
public class Jump {

    /**
     * 如果我们「贪心」地进行正向查找，每次找到可到达的最远位置，就可以在线性时间内得到最少的跳跃次数。
     * 在具体的实现中，我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，
     * 到达边界时，更新边界并将跳跃次数增加 1。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        //边界
        int end = 0;
        //记录目前能够跳到的最远位置
        int maxPosition = 0;
        //跳跃次数
        int steps = 0;
        //i < nums.length - 1，因为开始的时候边界是第 0个位置，steps 已经加 1了
        for (int i = 0; i < nums.length - 1; i++){
            //能跳的最远的位置
            maxPosition = Math.max(maxPosition, nums[i] + i);
            //第一次起跳 或 遇到边界
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。b
     *
     * 示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     *
     * 示例 2:
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     *
     * 思路：
     * 1、如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * 2、可以对每一个能作为 起跳点 的格子都尝试跳一次，把能跳到最远的距离不断更新。
     * 3、如果可以一直跳到最后，就成功了
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        //当前能到达的最远距离
        int k = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > k) {
                //当前元素下标大于max，说明永远达不到，直接返回
                return false;
            }
            //更新最远距离
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    /**
     * 动态规划
     * dp[i], 表示第i个位置能否到达
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i=1; i<len; i++) {
            for (int j=0; j<i; j++) {
                //遍历，前面的格子j可以到达，且可跳跃格数大于i-j
                if (dp[j] && nums[j] >= (i-j)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(new Jump().jump(a));
    }
}
