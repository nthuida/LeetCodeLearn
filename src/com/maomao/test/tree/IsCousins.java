package com.maomao.test.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 示例 1：
 *        1
 *       / \
 *     2    3
 *    /
 *   4
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 注：每个节点唯一
 *
 * @author huida
 * @date 2020/6/30
 */
public class IsCousins {

    /**
     * 求出每一个节点的深度与父节点。
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        //节点对应的深度
        Map<Integer, Integer> depthMap = new HashMap<>();
        //节点对应的父节点
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        dfs(root, null, depthMap, parentMap);
        if (depthMap.get(x).equals(depthMap.get(y)) && parentMap.get(x) != parentMap.get(y)) {
            return true;
        } else {
            return false;
        }
     }

    private void dfs(TreeNode root, TreeNode par, Map<Integer, Integer> depthMap,  Map<Integer, TreeNode> parentMap) {
        if (root != null) {
            //计算深度
            depthMap.put(root.val, par != null ? 1 + depthMap.get(par.val) : 0);
            //保存父节点
            parentMap.put(root.val, par);
            dfs(root.left, root, depthMap, parentMap);
            dfs(root.right, root, depthMap, parentMap);
        }
    }
}
