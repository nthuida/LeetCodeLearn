package com.maomao.test.tree;

import java.util.*;

/**
 * 二叉树层次遍历
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @Author huida.mao
 * @Date 2019/10/17
 */
public class LevelOrderBottom {

    /**
     * 从上到下层序遍历，在反转
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> integerList = new ArrayList<>();
            int size = queue.size();
            //一层的放在同一个list
            for (int i=0; i<size; i++) {
                TreeNode treeNode = queue.poll();
                integerList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            list.add(integerList);

        }
        Collections.reverse(list);
        return list;
    }
}
