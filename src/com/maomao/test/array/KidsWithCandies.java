package com.maomao.test.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。
 * 注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 * 示例
 * 输入：candies = [4,2,1,1,2], extraCandies = 1
 * 输出：[true,false,false,false,false]
 * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 *
 * @author huida
 * @date 2020/6/1
 */
public class KidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i=0; i<candies.length; i++) {
            if (candies[i] >=max) {
                max = candies[i];
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i=0; i<candies.length; i++) {
            if (candies[i] + extraCandies >=max) {
               res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
