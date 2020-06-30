package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * @author huida
 * @date 2020/6/30
 */
public class IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        int val = list.get(0);
        for (int i : list) {
            if (i != val) {
                return false;
            }
        }
        return true;
    }

    public void midOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }
}
