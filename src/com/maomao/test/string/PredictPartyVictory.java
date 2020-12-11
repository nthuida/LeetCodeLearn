package com.maomao.test.string;

/**
 * Dota2 参议院
 *
 * 示例 1：
 * 输入："RD"
 * 输出："Radiant"
 * 解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。
 * 然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
 *
 * 示例 2：
 * 输入："RDD"
 * 输出："Dire"
 * 解释：
 * 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
 * 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
 * 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 *
 * @author huida
 * @date 2020/12/11
 */
public class PredictPartyVictory {

    public String predictPartyVictory(String senate) {
        //Radiant总人数
        int radiantCount = 0;
        //Radiant当前被ban人数
        int curRadiantBan = 0;
        //Radiant被ban总人数
        int totalRadiantBan = 0;
        //Dire总人数
        int direCount = 0;
        //Dire当前被ban人数
        int curDireBan = 0;
        //Dire被ban总人数
        int totalDireBan = 0;
        //第一次循环标志
        boolean flag = true;
        char[] chars = senate.toCharArray();
        while (true) {
            for (int i=0; i<chars.length; i++) {
                char ch = chars[i];
                if (ch == 'R') {
                    if (flag) {
                        //第一次计数
                        radiantCount++;
                    }
                    if (curRadiantBan == 0) {
                        curDireBan++;
                        totalDireBan++;
                        if (totalDireBan == direCount && !flag) {
                            //第二次以后的循环
                            return "Radiant";
                        }
                    } else {
                        curRadiantBan--;
                        chars[i] = 'r';
                    }
                }

                if (ch == 'D') {
                    if (flag) {
                        //第一次计数
                        direCount++;
                    }

                    if (curDireBan == 0) {
                        curRadiantBan++;
                        totalRadiantBan++;
                        if (totalRadiantBan == radiantCount && !flag) {
                            return "Dire";
                        }
                    } else {
                        curDireBan--;
                        chars[i] = 'd';
                    }
                }
            }
           //第二次循环
            flag = false;
            if (totalDireBan >= direCount) {
                return "Radiant";
            }
            if (totalRadiantBan >= radiantCount) {
                return "Dire";
            }
        }

    }
}
