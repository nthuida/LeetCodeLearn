package com.maomao.test.array;

import java.util.*;

/**
 * 子集
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * @author huida
 * @date 2020/9/25
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.length == 0) {
            return res;
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int num : nums) {
            //取出之前的list, 拼接后再加入
            int size = res.size();
            for (int i=0; i<size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));
                //新的
                temp.add(num);
                //排序，去重
                Collections.sort(temp);
                if (!set.contains(temp)) {
                    res.add(temp);
                    set.add(temp);
                }

            }
        }
        return res;
    }
}
