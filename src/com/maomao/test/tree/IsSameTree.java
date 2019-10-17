package com.maomao.test.tree;

/**
 * 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 * @Author huida.mao
 * @Date 2019/10/17
 */
public class IsSameTree {
    /**
     * 递归 :找到退出条件
     * 值相等，且左右子树叶相等
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //都为空
        if (p == null && q == null) {
            return true;
        }
        //一个为空
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode pLeft = new TreeNode(2);
        TreeNode pRight = new TreeNode(3);
        p.left = pLeft;
        p.right = pRight;

        TreeNode q = new TreeNode(1);
        TreeNode qLeft = new TreeNode(2);
        TreeNode qRight = new TreeNode(3);
        q.left = qLeft;
        q.right = qRight;

        System.out.println(new IsSameTree().isSameTree(p, q));
    }
}
