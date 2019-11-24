package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * @Author huida.mao
 * @Date 2019/10/31
 */
public class BinaryTreePaths {

    /**
     * 递归，是子节点加入路径，不是则递归遍历该节点的每一个孩子节点
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        path(root, list, "");
        return list;
    }

    public void path(TreeNode root, List<String> pathList, String path) {
        if (root == null) {
            return;
        }
        path +=  root.val;
        if (root.right == null && root.left == null) {
            pathList.add(path);
        } else {
            //递归
            path += "->";
            path(root.left, pathList, path);
            path(root.right, pathList, path);
        }
    }
}
