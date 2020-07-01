package com.maomao.test.array;

import java.util.Map;

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
     * 定义dp[i][j]表示以A[i]和B[j]为结尾的公共子数组的最长长度
     * 当A[i]!=B[j]时，dp[i][j]=0, 因为以A[i]和B[j]结尾的公共子数组不存在，因为它们的末元素不等
     * 当A[i]==B[j]时，dp[i][j]=dp[i-1][j-1]+1, 因为A[i]和B[j]相等，以它们俩为结尾的最长公共子数组的长度就是以A[i-1]和B[j-1]结尾的最长公共子数组的长度加1
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int lenA = A.length;
        int lenB = B.length;
        if (lenA ==0 || lenB == 0) {
            return 0;
        }
        int[][] dp = new int[lenA][lenB];
        for (int i=0; i<lenA; i++) {
            //初始化第0行
            if (A[i] == B[0]) {
                dp[0][i] = 1;
                max = 1;
            }
        }

        for (int i=0; i<lenB; i++) {
            //初始化第0列
            if (B[i] == A[0]) {
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int i=1; i<lenB; i++) {
            for (int j=1; j<lenA; j++) {
                if (B[i] == A[j]) {
                    //i,j结尾的子数组相等, 因为是子数组，所以前一个为dp[i-1][j-1]
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
