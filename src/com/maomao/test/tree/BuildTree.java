package com.maomao.test.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author huida
 * @date 2020/5/22
 */
public class BuildTree {

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i=0; i<len;i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(preorder, 0,  len-1, inorder, 0, len-1);
    }

    public TreeNode buildHelper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        //递归终止条件，避免死循环
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        //构造根节点
        TreeNode root = new TreeNode(preorder[preorderStart]);
        //中序遍历根节点的位置
        int inorderRoot = map.get(preorder[preorderStart]);
        //左子树的长度
        int leftNum = inorderRoot - inorderStart;
        //递归构造左子树
        TreeNode left = buildHelper(preorder, preorderStart+1, preorderStart+leftNum, inorder, inorderStart,inorderRoot-1);
        //递归构造右子树
        TreeNode right = buildHelper(preorder, preorderStart +leftNum +1, preorderEnd, inorder, inorderRoot+1, inorderEnd);
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTreeII(int[] inorder, int[] postorder) {
        int len = postorder.length;
        for (int i=0; i<len;i++) {
            map.put(inorder[i], i);
        }
        return buildHelperII(postorder, 0,  len-1, inorder, 0, len-1);
    }

    public TreeNode buildHelperII(int[] postorder, int postorderStart, int postorderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        //递归终止条件，避免死循环
        if (postorderStart > postorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        //构造根节点
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        //中序遍历根节点的位置
        int inorderRoot = map.get(postorder[postorderEnd]);
        int leftNum = inorderRoot - inorderStart;
        //递归构造左子树
        TreeNode left = buildHelperII(postorder, postorderStart, postorderStart+leftNum-1, inorder, inorderStart,inorderRoot-1);
        root.left = left;
        //递归构造右子树
        TreeNode right = buildHelperII(postorder, postorderStart +leftNum, postorderEnd-1, inorder, inorderRoot+1, inorderEnd);
        root.right = right;
        return root;
    }
}
