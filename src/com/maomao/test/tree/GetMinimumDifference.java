package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * @author huida
 * @date 2020/6/24
 */
public class GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        //中序遍历有序
        List<Integer> temp = new ArrayList<>();
        midOrder(root, temp);
        int min = Integer.MAX_VALUE;
        for(int i=temp.size()-1; i>=1; i--) {
            int res = temp.get(i) - temp.get(i-1);
            if (res < min) {
                min = res;
            }
        }
        return min;
    }

    public void midOrder(TreeNode root,  List<Integer> list) {
        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }


    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifferenceII(TreeNode root) {
       midOrder(root);
       return min;
    }

    private void midOrder(TreeNode root) {
       if (root == null) {
           return;
       }
       midOrder(root.left);
       if (pre != null) {
           min = Math.min(min, root.val - pre.val);
       }
       pre = root;
       midOrder(root.right);
    }
}
