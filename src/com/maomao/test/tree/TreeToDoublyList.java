package com.maomao.test.tree;

/**
 * 二叉搜索树转为双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，
 * 最后一个节点的后继是第一个节点。
 *
 *
 * @author: huida
 * @date: 2022/2/25
 **/
public class TreeToDoublyList {

    //头节点和前驱节点
    TreeNode head, pre;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        //中序遍历
        midOrder(cur);
        //头节点和尾节点相互指向
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void midOrder(TreeNode cur) {
        if (cur != null) {
            midOrder(cur.left);
            if (pre == null) {
                //前驱为空，说明当前节点为头节点
                head = cur;
            } else {
                pre.right = cur;
            }
            //前驱和当前节点相互指向
            cur.left = pre;
            //更新前驱节点
            pre = cur;
            midOrder(cur.right);
        }
    }
}
