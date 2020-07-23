package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @author huida
 * @date 2020/7/21
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n ==0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    /**
     * 递归
     * 遍历n，以i为根节点，分为左右子树，在组合
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            //不符合，为空
            ans.add(null);
            return ans;
        }
        //枚举跟节点
        for (int i=start; i<=end; i++) {
           //左边所有可能的树
            List<TreeNode> left = generateTrees(start, i-1);
            //右边所有可能的树
            List<TreeNode> right = generateTrees(i+1, end);

            //组合
            for (TreeNode leftTreeNode : left) {
                for (TreeNode rightTreeNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTreeNode;
                    root.right = rightTreeNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
