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
     * 中序遍历 不行 比如[1,2,2,2,null,2],它不对称，但它回文
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        midOrder(root,stringBuilder);
        String midOrder = stringBuilder.toString();
        System.out.println(stringBuilder.toString());
        String reverse = new StringBuffer(stringBuilder).reverse().toString();
        return midOrder.equals(reverse);
    }
    public void midOrder(TreeNode node, StringBuilder stringBuilder) {
        if (node != null) {
            midOrder(node.left, stringBuilder);
            stringBuilder.append(node.val);
            midOrder(node.right,stringBuilder);
        }
    }

    /**
     * 递归
     * 如果同时满足下面的条件，两个树互为镜像：
     * 它们的两个根结点具有相同的值。
     * 每个树的右子树都与另一个树的左子树镜像对称
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
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
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
