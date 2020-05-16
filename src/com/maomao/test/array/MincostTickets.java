package com.maomao.test.array;

/**
 * 最低票价
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以
 * 一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：
 * 第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表days中列出的每一天的旅行所需要的最低消费。
 *
 * 示例 1：
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 *
 *  @Author huida.mao
 *  @Date 2020/05/07
 */
public class MincostTickets {

    /**
     * 动态规划  从后向前推
     * dp[i] = min(决策1, 决策2, 决策3);
     *       = min(c[0] + 1天后不包, c[1] + 7天后不包, c[2] + 30天不包);
     *       = min(c[0] + dp[i + 1], c[1] + dp[i + 7], c[2] + dp[i + 30]);
     *  dp[i] 为第 i 天开始，所需最小费用累计
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        // 多扩几天，省得判断 365 的限制
        int[] dp = new int[maxDay + 31];
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                // 别忘了递减一天
                i--;
            } else {
                // 不需要出门
                dp[d] = dp[d + 1];
            }
        }
        // 从后向前遍历，返回最前的 minDay
        return dp[minDay];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(new MincostTickets().mincostTickets(days, costs));
    }
}