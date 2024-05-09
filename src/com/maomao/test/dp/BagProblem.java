package com.maomao.test.dp;

/**
 * 背包问题
 * @auther: huida
 * @date: 2024/5/6
 */
public class BagProblem {

    public int getMaxValue(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length+1][bagSize+1];

        for (int i=1; i<=weight.length; i++) {
            for (int j=1; j<=bagSize; j++) {
                if (j< weight[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                }
            }
        }

        return dp[weight.length][bagSize];
    }

    public int getMaxValueII(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];
        for (int i=0; i<weight.length; i++) {
            for (int j=bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
                System.out.print(dp[j] + " ");
            }
            System.out.println();
            /*for (int j=weight[i]; j<=bagSize; j++) {
                //正序物品会重复放
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }*/
            System.out.print("物品 i= " + i );
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }

        //打印dp数组
        for (int j = 0; j <= bagSize; j++){
            System.out.print(dp[j] + " ");
        }

        return dp[bagSize];
    }


    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        System.out.println(new BagProblem().getMaxValueII(weight, value, bagWight));
    }

}
