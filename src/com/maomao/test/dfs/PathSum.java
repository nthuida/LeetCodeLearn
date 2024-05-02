package com.maomao.test.dfs;

import com.maomao.test.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径和
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> temp = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0,targetSum, temp, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, int targetSum, LinkedList<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        //加入路径
        list.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            //满足条件
            if (sum == targetSum) {
                res.add(new ArrayList<>(list));
                //回溯
                list.removeLast();
                //到达叶子节点，返回
                return;
            }
        }
        //不满足条件
        dfs(root.left, sum, targetSum, list, res);
        dfs(root.right, sum, targetSum, list, res);
        //回溯
        list.removeLast();
    }

    private void traceBack(TreeNode root, List<List<Integer>> res, LinkedList<Integer> path, int targetSum, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            traceBack(root.left, res, path, targetSum, sum);
            path.removeLast();
        }

        if (root.right != null) {
            traceBack(root.right, res, path, targetSum, sum);
            path.removeLast();
        }

    }


}
