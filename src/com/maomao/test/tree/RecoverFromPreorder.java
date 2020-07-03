package com.maomao.test.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。
 * （如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * 给出遍历输出 S，还原树并返回其根节点 root。
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

    /**
     * TODO
     * @param s
     * @return
     */
    public TreeNode recoverFromPreorder(String s) {
        //最终的返回的根节点
        TreeNode root = null;
        Stack<TreeNode> stack = new Stack<>();

        //记录上一次遍历到第几层
        int prevLevel = 0;

        //当前层
        int cutLevel = 0;

        //节点值
        int val = 0;
        int i = 0;
        while (i < s.length()){

            /**
             * 如果root==null，先设置根节点
             */
            if(root == null){
                //因为节点的值介于 1 和 10 ^ 9 之间，所以需要遍历计算val
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) -  '0');
                    i ++;
                }
                root = new TreeNode(val);

                //根节点入栈
                stack.push(root);
            }else if(s.charAt(i) == '-'){
                cutLevel ++;
                i++;
            }else {
                val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) -  '0');
                    i ++;
                }
                /**
                 * 左子树
                 * 如果当前cutLevel > prevLevel,说明是下一级，取栈顶节点
                 * */
                if(cutLevel > prevLevel){
                    TreeNode node = stack.pop();
                    node.left = new TreeNode(val);
                    //入栈的时候，需要将之前栈顶元素先入栈，然后node.left或者node.right再入栈
                    stack.push(node);
                    stack.push(node.left);
                    //然后cutLevel赋给prevLevel，cutLevel置0
                    prevLevel = cutLevel;
                    cutLevel = 0;
                } else {
                    /**
                     * 右子树
                     * 根据cutLevel的值，回溯到上一级
                     */
                    while (stack.size() > cutLevel){
                        stack.pop();
                    }
                    TreeNode node = stack.pop();
                    node.right = new TreeNode(val);
                    stack.push(node);
                    stack.push(node.right);
                    prevLevel = cutLevel;
                    cutLevel = 0;
                }
            }
        }
        return root;
    }

    public TreeNode recoverFromPreorderII(String S) {
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }
}
