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
 * 序列化为 "1,2,null,null,3,4,null,null,5,null,null,"
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
            return;
        }
        stringBuilder.append(root.val).append(",");
        mySerialize(root.left, stringBuilder);
        mySerialize(root.right,stringBuilder);

    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return myDeserialize(list);
    }

    private TreeNode myDeserialize(LinkedList<String> list) {
        if (list.getFirst().equals("null")) {
            list.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.getFirst()));
        list.removeFirst();
        root.left = myDeserialize(list);
        root.right = myDeserialize(list);
        return root;
    }
}
