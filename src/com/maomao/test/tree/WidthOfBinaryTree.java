package com.maomao.test.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * @author: huida
 * @date: 2022/5/18
 **/
public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        //保存节点在二叉树中对应的索引位置
        LinkedList<Integer> queueIndex = new LinkedList<>();
        queueNode.offer(root);
        queueIndex.add(1);
        int res = 1;
        while (!queueNode.isEmpty()) {
            int size = queueNode.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queueNode.poll();
                int curIndex = queueIndex.removeFirst();
                if (node.left != null) {
                    queueNode.offer(node.left);
                    //保存左节点的索引
                    queueIndex.add(curIndex*2);
                }
                if (node.right != null) {
                    queueNode.offer(node.right);
                    //保存右节点的索引
                    queueIndex.add(curIndex*2 +1);
                }
            }
            //计算当前层的最大宽度
            if (queueIndex.size() >=2) {
                res = Math.max(queueIndex.getLast() - queueIndex.getFirst() +1, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new WidthOfBinaryTree().widthOfBinaryTree(root));
    }
}
