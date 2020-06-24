package com.maomao.test.tree;

/**
 * 路径总和
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * @author huida
 * @date 2020/6/24
 */
public class PathSum {

    /**
     * 递归
     * 以当前节点作为头结点的路径数量
     * 以当前节点的左孩子作为头结点的路径数量
     * 以当前节点的右孩子作为头结点的路径数量
     * 最后求和
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int rootCount = countPath(root, sum);
        //左节点的路径和
        int leftCount = pathSum(root.left,sum);
        //右节点的和
        int rightCount = pathSum(root.right, sum);
        return rootCount + leftCount + rightCount;
    }

    private int countPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int count = 0;
        if (sum == 0) {
            //满足条件
            count++;
        }
        //左子树
        count += countPath(root.left, sum);
        //右子树
        count += countPath(root.right, sum );
        return count;
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        TreeNode node2  = new TreeNode(2);
        TreeNode node3  = new TreeNode(3);
        TreeNode node4  = new TreeNode(4);
        TreeNode node5  = new TreeNode(5);
        root.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        System.out.println(new PathSum().pathSum(root,3));
    }
}
