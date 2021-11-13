package com.maomao.test.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 *
 * 示例: 
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * @author huida
 * @date 2020/6/16
 */
public class Codec {


    /**
     * 先序遍历序列化
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        mySerialize(root, res);
        return res.toString();
    }

    private void mySerialize(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("null,");
        } else {
            stringBuilder.append(root.val).append(",");
            mySerialize(root.left, stringBuilder);
            mySerialize(root.right,stringBuilder);
        }
    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return myDeserialize(list);
    }

    private TreeNode myDeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root .left = myDeserialize(list);
        root.right = myDeserialize(list);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);
        root.right = right;
        String data = new Codec().serialize(root);
        System.out.println(data);

        TreeNode node = new Codec().deserialize(data);
        System.out.println(node);
    }
}
