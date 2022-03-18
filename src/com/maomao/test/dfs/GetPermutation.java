package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第K个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 *
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * @author huida
 * @date 2020/10/22
 */
public class GetPermutation {

    public String getPermutation(int n, int k) {
        List<Integer> res = permute(n);
        Collections.sort(res);
        return res.get(k-1).toString();
    }

    /**
     * 全排列
     * @param n
     * @return
     */
    public List<Integer> permute(int n) {
        //路径
        StringBuilder track = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        int[] num = new int[n];
        for (int i=0; i<n; i++) {
            num[i] = i+1;
        }
        backtrack(num , track, result);
        return result;
    }

    public void backtrack(int[] num, StringBuilder track, List<Integer> result) {
        // 触发结束条件
        if (track.length() == num.length) {
            result.add(Integer.parseInt(new String(track)));
            return;
        }

        for (int i = 0; i <num.length; i++) {
            // 排除不合法的选择
            if (track.indexOf(num[i] + "") != -1) {
                continue;
            }
            // 做选择
            track.append(num[i]);
            // 进入下一层决策树
            backtrack(num, track, result);
            // 取消选择
            track.deleteCharAt(track.length()-1);
        }

    }

    /**
     * 通过 计算剩余数字个数的阶乘数，一位一位选出第 k 个排列的数位。
     *
     * 所求排列 一定在叶子结点处得到，进入每一个分支，可以根据已经选定的数的个数，进而计算还未选定的数的个数，然后计算阶乘，
     * 就知道这一个分支的 叶子结点 的个数：
     * 如果 k 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫「剪枝」；
     * 如果 k 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutationII(int n, int k) {
        //记录当前的索引的数是否被使用过
        boolean[] used = new boolean[n+1];
        StringBuilder res = new StringBuilder();
        dfs(res, used, 0, n, k);
        return res.toString();
    }


    private void dfs(StringBuilder path, boolean[] used, int depth, int n, int k) {
        if (depth == n) {
            //触发结束条件
            return;
        }
        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cur = factorial(n - depth - 1);
        for (int i = 1; i <= n; i++) {
            //当前元素被使用过，做剪枝
            if (used[i]) {
                continue;
            }
            if (cur < k) {
                //当前的排列组合数小于k，说明就算这一层排完了，也到不了第k个，剪枝
                k -= cur;
                continue;
            }
            path.append(i);
            //当前元素被使用过标记
            used[i] = true;
            dfs(path, used, depth + 1, n, k);
        }
        return ;
    }



    /**
     * 返回n的阶乘，如3!=3*2*1=6
     * @param n
     * @return
     */
    private int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(8,35784));
    }
}
