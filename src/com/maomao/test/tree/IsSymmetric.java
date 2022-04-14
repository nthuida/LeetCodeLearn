package com.maomao.test.tree;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * @Author huida.mao
 * @Date 2019/10/17
 */
public class IsSymmetric {

    /**
     * 递归
     * 1、根结点具有相同的值。
     * 2、每个树的右子树都与另一个树的左子树镜像对称
     * 3、每个树的左子树都与另一个树的右子树镜像对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        //终止条件
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode pLeft = new TreeNode(2);
        TreeNode pRight = new TreeNode(2);
        p.left = pLeft;
        p.right = pRight;
        System.out.println(new IsSymmetric().isSymmetric(p));
    }
}
