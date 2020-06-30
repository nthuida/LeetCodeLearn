package com.maomao.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树节点最小距离
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * @author huida
 * @date 2020/6/30
 */
public class MinDiffInBST {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        int min = Integer.MAX_VALUE;
        for (int i= list.size()-1; i-1>=0; i--) {
            int temp = list.get(i) - list.get(i-1);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public void midOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            midOrder(root.left, list);
            list.add(root.val);
            midOrder(root.right, list);
        }
    }
}
