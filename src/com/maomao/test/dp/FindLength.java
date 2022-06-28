package com.maomao.test.dp;

/**
 * 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * @author huida
 * @date 2020/7/1
 */
public class FindLength {

    /**
     * 动态规划
     * 定义状态：dp[i][j]表示以A[i]和B[j]为结尾的公共子数组的最大长度
     * 状态转移方程
     * dp[i][j] = 0,   子数组是连续的  A[i]!=B[j]
     * dp[i][j] = dp[i-1][j-1] + 1, A[i]==B[j]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
