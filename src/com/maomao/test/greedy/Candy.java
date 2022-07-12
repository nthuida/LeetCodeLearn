package com.maomao.test.greedy;

import java.util.Arrays;

/**
 * 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * @author huida
 * @date 2020/12/24
 */
public class Candy {

    /**
     * 先找从左到右满足最少的糖果，再找从右到左的，最后取两边都满足的值
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left= new int[len];
        int[] right = new int[len];
        //左右数组都初始化为1
        Arrays.fill(left,1);
        Arrays.fill(right, 1);

        for (int i=1; i<len; i++) {
            //从左往右
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            }
        }
        for (int j=len-2; j>=0; j--) {
            //从右往左
            if (ratings[j] > ratings[j+1]) {
                right[j] = right[j+1] + 1;
            }
        }
        int res = 0;
        //比较取最大值
        for (int k=0; k<len; k++) {
            res += Math.max(left[k], right[k]);
        }

        return res;
    }

}
