package com.maomao.test.tree;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author huida
 * @date 2020/9/8
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int j = 1;
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
            if ((j&1) == 0)  {
                //从右往左
                Collections.reverse(integerList);
            }
            j++;
            list.add(integerList);

        }
        return list;
    }
}
