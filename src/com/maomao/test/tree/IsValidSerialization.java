package com.maomao.test.tree;

import java.util.LinkedList;

/**
 * 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 *
 * @author: huida
 * @date: 2021/12/20
 **/
public class IsValidSerialization {

    /**
     * 把有效的叶子节点使用 "#" 代替。 比如把 4## 替换成 #
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        LinkedList<String> stack = new LinkedList<>();
        for (String s : preorder.split(",")) {
            stack.push(s);
            while (stack.size()>=3 && stack.get(0).equals("#") && stack.get(1).equals("#") && !stack.get(2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }

        return stack.size() == 1 && stack.pop().equals("#");
    }

}
