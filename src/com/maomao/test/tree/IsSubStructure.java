package com.maomao.test.tree;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * @author: huida
 * @date: 2022/5/20
 **/
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isContain(A,B)) {
            return true;
        }
        //遍历A中每个节点，A树中任一节点包含B就能返回true
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * p为根节点的树是否包含q，从P开始比较
     * @param p
     * @param q
     * @return
     */
    private boolean isContain(TreeNode p, TreeNode q) {
        //q已比较完，说明是P的子结构
        if (q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        //继续判断子结构
        return isContain(p.left, q.left) && isContain(p.right, q.right);
    }

}
