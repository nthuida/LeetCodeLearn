package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * @Author huida.mao
 * @Date 2019/12/20
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        //路径
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(n, k, 1, track, result);
        return result;
    }

    public void backtrack(int n, int k, int start, LinkedList<Integer> track, List<List<Integer>> result) {
        // 触发结束条件
        if (track.size() == k) {
            result.add(new LinkedList(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            // 做选择
            track.add(i);
            // 进入下一层决策树
            backtrack(n,k,i+1, track, result);
            // 取消选择
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
