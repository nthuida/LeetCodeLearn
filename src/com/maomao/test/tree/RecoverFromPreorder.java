package com.maomao.test.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索， 在遍历中的每个节点处，我们输出D条短划线（其中 D 是该节点的深度），然后输出该节点的值。
 * （如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。给出遍历输出S，还原树并返回其根节点root。
 *
 * 示例 1：
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 *
 * @author huida
 * @date 2020/6/18
 */
public class RecoverFromPreorder {

    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            //计算深度
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            //计算节点值
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                //寻找父节点
                if (!path.isEmpty()) {
                    //前一个节点的左子节点为当前节点
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    //找父节点
                    path.pop();
                }
                //因为此时左子节点已确定，所以赋值给右子节点
                path.peek().right = node;
            }
            path.push(node);
        }
        //获取根节点
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }
}
