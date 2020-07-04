package com.maomao.test.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author huida
 * @date 2020/7/4
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.length == 0) {
            return res;
        }
        for (int num : nums) {
            //取出之前的list, 拼接后再加入
            int size = res.size();
            for (int i=0; i<size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));
                //新的
               temp.add(num);
               res.add(temp);
            }
        }
        return res;
    }
}
