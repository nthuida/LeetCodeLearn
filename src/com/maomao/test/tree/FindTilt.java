package com.maomao.test.tree;

/**
 * 二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例：
 *
 * 输入：
 *          1
 *        /   \
 *       2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *  
 * @author huida
 * @date 2020/6/24
 */
public class FindTilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    /**
     * 自底向上不断返回子树的所有节点之和，然后计算并累加当前结点的坡度，再向上返回当前树的结点之和。
     * 直到根结点的坡度得到计算后，递归遍历结束，所有节点的坡度之和就出来了。
     * @param root
     * @return
     */
    public int traverse(TreeNode root) {
        if (root==null) {
            return 0;
        }
        //左节点的和
        int left = traverse(root.left);
        //右节点和
        int right = traverse(root.right);
        //计算当前节点的坡度
        tilt += Math.abs(left-right);
        //返回当前树的结点之和
        return left + right + root.val;
    }
}
