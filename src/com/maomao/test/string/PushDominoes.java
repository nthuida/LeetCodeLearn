package com.maomao.test.string;

/**
 * 推多米诺
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 * 示例 1：
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 *
 * 示例 2：
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 *
 * @author: huida
 * @date: 2022/2/22
 **/
public class PushDominoes {

    /**
     * 多米诺骨牌的四种情况
     *      'R......R' => 'RRRRRRRR'
     *      'R......L' => 'RRRRLLLL' or 'RRRR.LLLL'
     *      'L......R' => 'L......R'
     *      'L......L' => 'LLLLLLLL'
     *      两个相邻的被推倒的牌互不影响。
     *      一张站立的牌（"."）的最终状态与离其两侧最近的 "L" 或 "R" 有关。
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        //增加虚拟端点
        dominoes = "L" + dominoes + "R";
        int length = dominoes.length();
        StringBuffer buffer = new StringBuffer();
        int left = 0;
        for (int right=1; right<length; right++) {
            //寻找区间
            if (dominoes.charAt(right) == '.') {
                continue;
            }
            //虚拟牌不放
            if (left != 0) {
                //因为左边的端点下一次会移动到当前的右端点位置
                //所以这里只添加左端点，就可以将每次区间的端点加进去
                buffer.append(dominoes.charAt(left));
            }
            //中间'.'的个数
            int mid = right - left - 1;
            if (dominoes.charAt(left) == dominoes.charAt(right)) {
                for(int i=0; i<mid; i++) {
                    buffer.append(dominoes.charAt(left));
                }
            } else if (dominoes.charAt(left) == 'L' && dominoes.charAt(right) == 'R') {
                for(int i=0; i<mid; i++) {
                    buffer.append('.');
                }
            } else {
                for (int i=0; i<mid/2; i++) {
                    buffer.append('R');
                }
                if (mid %2 != 0) {
                    buffer.append('.');
                }
                for (int i=0; i<mid/2; i++) {
                    buffer.append('L');
                }
            }
            //将左端点的位置移动到右端点，下次的区间从当前区间的右端点开始
            left = right;
        }
        return buffer.toString();
    }
}
