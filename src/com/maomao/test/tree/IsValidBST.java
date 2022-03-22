package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @Author huida.mao
 * @Date 2020/05/07
 */
public class IsValidBST {

    /**
     * 中序遍历判断
     * @param root
     * @return
     */

    //记录上一节点的值
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点，当前节点的值应该大于所有左子树的值
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    List<Integer> list = new ArrayList<>();
    public boolean isValidBSTII(TreeNode root) {
        if (root == null) {
            return true;
        }
        midOrder(root);
        //判断有序
        for (int i=0; i<list.size()-1; i++) {
            if (list.get(i) < list.get(i+1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            list.add(root.val);
            midOrder(root.right);
        }
    }
}
