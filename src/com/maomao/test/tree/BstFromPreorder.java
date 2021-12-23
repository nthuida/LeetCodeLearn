package com.maomao.test.tree;

/**
 * 前序遍历构造二叉搜索树
 * 示例：
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 *
 * @author: huida
 * @date: 2021/12/23
 **/
public class BstFromPreorder {

    /**
     * 根节点在第一位，后面接着左子树和右子树；
     * BST 的特点，左子树都比根节点的值小，右子树都比根节点的值大。
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length-1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preorder[start];
        TreeNode root = new TreeNode(val);
        int p = start+1;
        //寻找左子树
        while (p<=end && preorder[p] < preorder[start]) {
            p++;
        }
        root.left = build(preorder, start+1, p-1);
        root.right = build(preorder, p, end);

        return root;

    }
}
