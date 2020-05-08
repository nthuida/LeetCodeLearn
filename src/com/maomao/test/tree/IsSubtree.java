package com.maomao.test.tree;

/**
 * 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 ** @Author huida.mao
 *  * @Date 2020/05/07
 */
public class IsSubtree {

    /**
     * 递归判断一个树的子树和另一个树是否相等
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
       if (s == null) {
           return false;
       }
       if (isSameTree(s,t)) {
           return true;
       }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断两个树是否相等
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
        TreeNode root = new TreeNode(4);
        TreeNode p = new TreeNode(1);
        TreeNode pLeft = new TreeNode(2);
        TreeNode pRight = new TreeNode(3);
        p.left = pLeft;
        p.right = pRight;
        root.left = p;

        TreeNode q = new TreeNode(1);
        TreeNode qLeft = new TreeNode(2);
        TreeNode qRight = new TreeNode(3);
        q.left = qLeft;
        q.right = qRight;

        System.out.println(new IsSubtree().isSubtree(root, q));
    }
}
