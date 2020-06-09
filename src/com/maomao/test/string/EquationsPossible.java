package com.maomao.test.string;

/**
 * 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
 * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 * 示例 1：
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。
 * 没有办法分配变量同时满足这两个方程。
 *
 * 示例 2：
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 *
 * 示例 3：
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 *
 * 示例 4：
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 *
 * 示例 5：
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *  
 * 提示：
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 *
 * @author huida
 * @date 2020/6/9
 */
public class EquationsPossible {

    /**
     * 先找==的,并用一个长度26的数组记录每个字母对应的数字,将相等的字母的权值用同一个数字表示
     * 比如a=b=c=d=1,e=f=g=2,如果出现交集,如a=e,则把这两条的权值全部置成一样的,即a=b=c=d=e=f=g=1
     *
     * 然后再找!=,如果两个字母都没出现过或只有一个出现过,就不用管,因为肯定正确,
     * 如果都出现过,就直接比较权值,权值相同就返回false
     *
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        int[] counter = new int[26];
        int count = 1;
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                //找相等的，计数
                int a = str.charAt(0) - 'a';
                int b = str.charAt(3) - 'a';
                if (counter[a] == 0 && counter[b] ==0) {
                    //都是第一次出现
                    counter[a] = counter[b] = count++;
                } else if (counter[a] == 0 || counter[b] ==0) {
                    //有一个第一次出现
                    int max = Math.max(counter[a], counter[b]);
                    counter[a] = counter[b] = max;
                } else {
                    //都出现过
                    int value = counter[a];
                    int value2 = counter[b];
                    for (int i = 0; i < counter.length; i++) {
                        if (counter[i] == value || counter[i] == value2) {
                            counter[i] = value;
                        }
                    }
                }
            }
        }
        //寻找不相等
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                if (a == b) {
                    //自己和自己一定相等
                    return false;
                }
                if (counter[a] != 0 && counter[b] != 0) {
                    //都出现过
                    if (counter[a] == counter[b]) {
                        //值一样，说明两者相等
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
