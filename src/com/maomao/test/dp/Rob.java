package com.maomao.test.dp;

import com.maomao.test.tree.TreeNode;

import java.util.*;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @Author huida.mao
 * @Date 2019/10/29
 */
public class Rob {

    /**
     * 标签：动态规划
     * 转移方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
     * 在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，
     * 要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        //打劫到第0家
        dp[0] = 0;
        //打劫到第1家
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            //前一家不偷：dp[i-2] + num, 前一家偷：dp[i-1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     *
     * 示例 1：
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     * 示例 2：
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 示例 3：
     * 输入：nums = [0]
     * 输出：0
     *
     * 分两种，第一个不抢   最后一个不抢
     * @param nums
     * @return
     */
    public int robII(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int way1 = rob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int way2 = rob(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(way1,way2);
    }

    /**
     * 打家劫舍
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     *
     * 示例 2:
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     */

    /**
     *  动态规划
     *  我们使用一个大小为 2 的数组来表示 dp[] 0 代表不偷，1 代表偷
     *  任何一个节点能偷到的最大钱的状态可以定义为
     *  当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     *  当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择自己不偷时能得到的钱 + 当前节点的钱数
     *
     */
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int[] dp = new int[2];
        //dp[0]当前节点不偷
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //dp[1]当前节点偷
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(new Rob().rob(nums));

        System.out.println(new Rob().robII(nums));
    }
}
