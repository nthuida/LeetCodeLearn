package com.maomao.test.prefixSum;

import com.maomao.test.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 路径总和
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * @author huida
 * @date 2020/6/24
 */
public class PathSum {

    /**
     * 遍历每个节点，以该节点为起点，计算总的路径数
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //以根节点为起点的路径和
        int rootCount = countPath(root, sum);
        //以左节点为起点的路径和
        int leftCount = pathSum(root.left,sum);
        //以右节点为起点的路径和
        int rightCount = pathSum(root.right, sum);
        return rootCount + leftCount + rightCount;
    }

    /**
     * 计算以某个节点为起点的路径总数
     * @param root
     * @param sum
     * @return
     */
    private int countPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int count = sum == 0 ? 1 : 0;

        return count + countPath(root.left, sum) + countPath(root.right, sum);
    }

    /**
     * 前缀和：当前节点到根节点的和
     * @param root
     * @param sum
     * @return
     */
    int count = 0;
    public int pathSumIII(TreeNode root, int sum) {
       if (root == null) {
           return 0;
       }
       //key为前缀和，value为次数
       Map<Long, Long> map = new HashMap<>();
       //为了得到子节点到根节点的路径
       map.put((long)0,(long)1);
       dfs(root, sum, 0, map);
       return count;
    }

    private void dfs(TreeNode root, int target, long curSum, Map<Long, Long> map) {
        if (root == null) {
            return;
        }
        //当前的前缀和
        curSum += root.val;
        //如果存在前缀和为curSum-target的节点，则两个节点之间的路径和正好为target,
        count += map.getOrDefault(curSum-target, (long)0);
        //前缀和计数
        map.put(curSum, map.getOrDefault(curSum, (long)0) +1);

        //左右子树，curSum不回溯 值传递，每层递归的值不一样
        dfs(root.left, target, curSum, map);
        dfs(root.right, target, curSum, map);
        //回溯，回到上一层
        map.put(curSum, map.get(curSum)-1);
    }
}
