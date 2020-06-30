package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 以 10^9 + 7 为模，返回这些数字之和。
 *
 * 示例：
 *           1
 *         /   \
 *       0      1
 *      / \    / \
 *    0   1   0   1
 *
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * @author huida
 * @date 2020/6/30
 */
public class SumRootToLeaf {
    int mod = 10^9 +7;
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        cur = (cur * 2 + root.val);
        if (root.left==null && root.right==null) {
            //到达叶子节点
            sum += cur;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }

}
