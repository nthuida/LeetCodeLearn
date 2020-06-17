package com.maomao.test.array;

/**
 * 最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * 示例：
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * @author huida
 * @date 2020/6/17
 */
public class MaxScoreSightseeingPair {

    /**
     * res = A[i] + A[j] + i - j （i < j），我们求每个景点j的时候，A[j] - j 实际上是固定的，要想让res最大，我们就要想办法让A[i] + i尽可能大
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0;
        for (int i=0; i<A.length; i++) {
            for (int j=i+1; j<A.length; j++) {
                int score = A[i] + A[j] + i - j;
                if (score > max) {
                    max = score;
                }
            }
        }
        return max;
    }

    public int maxScoreSightseeingPairII(int[] A) {
        int max = 0;
        int temp = A[0] + 0;
        for (int i=1; i<A.length; i++) {
            max = Math.max(max, temp + A[i]-i);
            temp = Math.max(temp, A[i] + i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {8,1,5,2,6};
        System.out.println(new MaxScoreSightseeingPair().maxScoreSightseeingPairII(A));
    }
}
