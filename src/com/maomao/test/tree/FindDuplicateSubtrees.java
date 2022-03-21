package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 *
 * @author: huida
 * @date: 2021/11/16
 **/
public class FindDuplicateSubtrees {

    List<TreeNode> res = new ArrayList<>();
    //记录所有子树出现的次数
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrder(root);
        return res;
    }

    /**
     * 1、先把二叉树序列化
     * 2、比较重复
     * @param treeNode
     * @return
     */
    private String postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return "#";
        }
        //后序遍历序列化
        String left = postOrder(treeNode.left);
        String right = postOrder(treeNode.right);
        String subTree = left + "," + right + "," + treeNode.val;
        int count = map.getOrDefault(subTree, 0);
        if (count == 1) {
            //重复只添加一次
            res.add(treeNode);
        }
        map.put(subTree, count+1);
        return subTree;
    }

}
