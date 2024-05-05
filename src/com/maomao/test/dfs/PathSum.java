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


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);


        TreeNode node13 = new TreeNode(13);

        TreeNode rnode4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        rnode4.left = node5;
        rnode4.right = node1;

        TreeNode node8 = new TreeNode(8);
        node8.left = node13;
        node8.right = rnode4;

        TreeNode node4 = new TreeNode(4);

        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        node11.left = node7;
        node11.right = node2;

        node4.left = node11;

        root.left = node4;
        root.right = node8;



        List<List<Integer>> res = new PathSum().pathSum(root, 22);
        System.out.println(res);


    }
}
