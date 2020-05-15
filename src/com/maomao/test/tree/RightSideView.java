package com.maomao.test.tree;

import java.util.*;

/**
 * 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author huida
 * @date 2020/5/15
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        //层序遍历，取每一层的最后一个元素
        List<List<Integer>> lists = levelOrder(root);
        for (int i=0; i<lists.size(); i++) {
            List<Integer> list = lists.get(i);
            resultList.add(list.get(list.size()-1));
        }
        return resultList;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return list;
    }


}
