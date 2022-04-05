package com.maomao.test.dfs;

import com.maomao.test.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * @author huida
 * @date 2020/9/29
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> res = getPath(root);
        int sum = 0;
        for (int i=0; i<res.size(); i++) {
            List<Integer> path = res.get(i);
            int partSum = 0;
            for (int k : path) {
                partSum = partSum * 10  + k;
            }
            sum += partSum;
        }
        return sum;
    }

    /**
     * 所有路径
     * @param root
     * @return
     */
    private List<List<Integer>> getPath(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(root, temp, res);
        return res;
    }

    private void dfs(TreeNode root, LinkedList<Integer> list, List<List<Integer>> res ) {
        if (root == null) {
            return;
        }
        //加入路径
        list.add(root.val);
        if (root.left == null && root.right == null) {
            //满足条件
            res.add(new ArrayList<>(list));
            //回溯
            list.removeLast();
            //到达叶子节点，返回
            return;
        }
        //不满足条件
        dfs(root.left, list, res);
        dfs(root.right, list, res);
        //回溯
        list.removeLast();
    }

    /**
     * 先遍历根节点；
     * 遍历左子树，遍历左子树的时候，把走当前路径的数字带到左子树的求解中；
     * 遍历右子树，遍历右子树的时候，把走当前路径的数字带到右子树的求解中；
     * 更新总的和。
     * @param root
     * @return
     */
    public int sumNumbersII(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i){
        //终止条件
        if (root == null) {
            return 0;
        }
        //计算当前节点的值
        int temp = i * 10 + root.val;
        //叶子节点，一条完整的路径，直接返回
        if (root.left == null && root.right == null) {
            return temp;
        }
        //非叶子节点，递归左右子树
        return helper(root.left, temp) + helper(root.right, temp);
    }


}
