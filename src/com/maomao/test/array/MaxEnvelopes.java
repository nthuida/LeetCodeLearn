package com.maomao.test.array;

import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 * 示例 1：
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 *
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 *
 * @author: huida
 * @date: 2021/12/14
 **/
public class MaxEnvelopes {

    /**
     * 首先将所有的信封按照w值第一关键字升序、h值第二关键字降序进行排序；
     * 随后就可以忽略w维度，求出h维度的最长严格递增子序列，其长度即为答案。
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        //以w升序排列，当w相等时，以h降序排列
        Arrays.sort(envelopes, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e2[1] - e1[1];
            } else {
                return e1[0] - e2[0];
            }
        });
        //以h列为维度，求最长递增子序列
        int res = 1;
        int[] dp = new int[envelopes.length];
        //初始化为1
        Arrays.fill(dp, 1);
        for (int i=1; i<envelopes.length; i++) {
            for (int j=0; j<i; j++) {
                //遍历求dp
                if(envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
