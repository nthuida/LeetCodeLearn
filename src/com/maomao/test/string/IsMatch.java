package com.maomao.test.string;

/**
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * @author huida
 * @date 2020/6/16
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        //TODO
        //需要分别取出s和p为空的情况，所以dp数组大小+1
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        //初始化dp[0][0]=true,dp[0][1]和dp[1][0]~dp[s.length][0]默认值为false所以不需要显式初始化
        dp[0][0]=true;
        //填写第一行dp[0][2]~dp[0][p.length]
        for (int k=2;k<=p.length();k++){
            //p字符串的第2个字符是否等于'*',此时j元素需要0个，所以s不变p减除两个字符
            dp[0][k]=p.charAt(k-1)=='*'&&dp[0][k-2];
        }
        //填写dp数组剩余部分
        for (int i=0;i<s.length();i++){
            for (int j=0;j<p.length();j++){
                //p第j个字符是否为*
                if (p.charAt(j)=='*'){
                    //两种情况:1.s不变[i+1],p移除两个元素[j+1-2]。
                    // 2.比较s的i元素和p的j-1(因为此时j元素为*)元素,相等则移除首元素[i+1-1],p不变。
                    dp[i+1][j+1]=dp[i+1][j-1]|| (dp[i][j+1]&&headMatched(s,p,i,j-1));
                }else {
                    //s的i元素和p的j元素是否相等,相等则移除s的i元素[i+1-1]和p的j元素[j+1-1]
                    dp[i+1][j+1]=dp[i][j]&&headMatched(s,p,i,j);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * 判断s第i个字符和p第j个字符是否匹配
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public boolean headMatched(String s,String p,int i,int j){
        return s.charAt(i)==p.charAt(j)||p.charAt(j)=='.';
    }

}
