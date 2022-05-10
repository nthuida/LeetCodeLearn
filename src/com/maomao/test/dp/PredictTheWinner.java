package com.maomao.test.dp;

/**
 * 预测赢家
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，
 * 然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
 * 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 示例 1：
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。
 * 如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 *
 * 示例 2：
 * 输入：[1, 5, 233, 7]
 * 输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 *
 * @author huida
 * @date 2020/9/1
 */
public class PredictTheWinner {

    /**
     * 动态规划
     * dp[i][j]表示从nums[i]到nums[j]先手比另一位玩家多的最大分数，最后返回dp[0][nums.length-1]是否大于0即可
     *
     * 对于dp[i][j]，如果先手拿了nums[i]，则另一位玩家比先手多dp[i+1][j]，dp[i][j] = nums[i]-dp[i+1][j]，
     * 如果先手拿了nums[j]，则另一位玩家比先手多dp[i][j-1]，dp[i][j] = nums[j]-dp[i][j-1]
     * 综上，转态转移方程：dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1])
     *
     * @param nums
     * @return
     */
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        //初始化，当i和j相等时，只存在一个数，先手赢
        for (int i=0; i<len; i++) {
            dp[i][i] = nums[i];
        }

        for (int i=len-2; i>=0; i--) {
            //因为较小的i值（状态转移方程中的i）是由较大的i值（状态转移方程中的i+1）得到的
            for (int j=i+1; j<len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len-1] >=0;
    }
}
