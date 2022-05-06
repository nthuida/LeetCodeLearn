package com.maomao.test.stack;

import java.util.Stack;

/**
 * 简化路径
 * 返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。
 * 此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 *
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * @author huida
 * @date 2020/9/24
 */
public class SimplifyPath {

    /**
     *  栈: 把当前目录压入栈中,遇到..弹出栈顶,最后返回栈中元素.
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        //  分割
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (str.equals("..") && !stack.isEmpty()) {
                //不为空，出栈
                stack.pop();
            } else if (!str.equals("") && !str.equals(".") && !str.equals("..")) {
                //路径
                stack.push(str);
            }
        }
        //栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<stack.size(); i++) {
            stringBuilder.append("/").append(stack.get(i));
        }

        return stringBuilder.toString();
    }

}
