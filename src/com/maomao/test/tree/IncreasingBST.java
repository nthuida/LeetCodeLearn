package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * @author huida
 * @date 2020/6/30
 */
public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        TreeNode res = new TreeNode(list.get(0));
        TreeNode temp = res;
        for (int i=1; i<list.size(); i++) {
            TreeNode node = new TreeNode(list.get(i));
            temp.right = node;
            temp = node;
        }
        return res;
    }

    public void midOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }
}
