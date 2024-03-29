package com.maomao.test.dp;

/**
 * 最低票价
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以
 * 一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：
 * 第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
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
     * 状态定义：dp[i] 表示第i天为止，所需的最小费用
     * 状态转移方程：dp[i]  = min(c[0] + dp[i-1], c[1] + dp[i-7], c[2] + dp[i-30])
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int lastDay = days[len-1];
        int[] dp = new int[lastDay+1];
        //days的索引
        int index = 0;
        for (int i=1; i<=lastDay; i++) {
            if (i == days[index]) {
                //买一天
                int way1 = dp[i-1] + costs[0];
                //如果今天距离第一天已经超过7天了，则花费: dp[i-7](7天前已经花费的钱)+cost[1](7天前买了一张7天的票)
                //否则就是直接第一天买了一张7天票
                int way2 = i-7>0 ? dp[i-7] + costs[1] : costs[1];
                //买30天
                int way3 = i-30>0 ? dp[i-30] + costs[2] : costs[2];
                dp[i] = Math.min(Math.min(way1,way2), way3);
                index++;
            } else {
                dp[i] = dp[i-1];
            }
        }

        return dp[lastDay];
    }
}
