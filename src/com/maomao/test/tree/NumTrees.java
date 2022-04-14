package com.maomao.test.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 * @author: huida
 * @date: 2022/4/14
 **/
public class NumTrees {

    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n == 0 || n==1) {
            return 1;
        }
        //减少重复计算
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        for (int i=1; i<=n; i++) {
            //已i为根节点，左边可以构成二叉搜索树的数量
            int leftCount = numTrees(i-1);
            //右边
            int rightCount = numTrees(n-i);
            //累加
            count += leftCount*rightCount;
        }
        //保存
        map.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }
}
