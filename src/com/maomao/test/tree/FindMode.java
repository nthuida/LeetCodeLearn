package com.maomao.test.tree;

import java.util.*;

/**
 * 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * @author huida
 * @date 2020/6/24
 */
public class FindMode {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        //中序遍历计数
        midOrder(root, map);
        int max = Collections.max(map.values());
        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }
       int[] result = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public void midOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            midOrder(root.left, map);
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            midOrder(root.right, map);
        }
    }
}
