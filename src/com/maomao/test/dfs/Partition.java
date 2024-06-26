package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @author huida
 * @date 2020/9/8
 */
public class Partition {

    /**
     * 回溯
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        LinkedList<String> path = new LinkedList<>();
        backtrack(0, s, path, res);
        return res;
    }

    private void backtrack(int start, String s, LinkedList<String> path, List<List<String>> res) {
        //结束条件
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=start; i<s.length(); i++) {
            String str = s.substring(start, i+1);
            //不满足条件
            if (!check(str)) {
                continue;
            }
            //选择
            path.add(str);
            //进入下一步
            backtrack(i+1, s, path, res);
            //回溯
            path.removeLast();
        }
    }


    private boolean check(String s) {
        StringBuilder builder = new StringBuilder(s);
        return s.equals(builder.reverse().toString());
    }

}
