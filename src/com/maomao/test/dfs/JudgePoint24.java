package com.maomao.test.dfs;
import java.util.LinkedList;

/**
 * 24点
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 *
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 *
 * 注意:
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 *
 * @author huida
 * @date 2020/8/22
 */
public class JudgePoint24 {

    /**
     * 回溯法
     * 全排列： （12*4）* （6*4） * （2*4）=  9216
     *
     * @param nums
     * @return
     */
    public boolean judgePoint24(int[] nums) {
        LinkedList<Double> list = new LinkedList<>();
        // '/'不是整除，转为浮点数
        for (int a : nums) {
            list.add((double)a);
        }
        return judge(list);
    }

    private boolean judge(LinkedList<Double> list) {
        // le-6是浮点计算的精度误差，这里判断误差小于1e-6，这样就是正确结果
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        //每次选择两个不同的数进行计算
        for (int i=0; i< list.size() ;i++) {
            for (int j=0; j<list.size(); j++) {
                if (i != j) {
                    //保存计算以后的数
                    LinkedList<Double> next = new LinkedList<>();
                    for (int k=0; k<list.size(); k++) {
                        if (k!=i && k!=j) {
                            next.add(list.get(k));
                        }
                    }
                    //4种计算组合
                    for (int n=0; n<4; n++) {
                        if (n==0) {
                            next.add(list.get(i) - list.get(j));
                        } else if (n==1) {
                            next.add(list.get(i) * list.get(j));
                        } else if (n==2) {
                            next.add(list.get(i) + list.get(j));
                        } else {
                            //被除数为0
                            if (Math.abs(list.get(j)) < 1e-6) {
                                continue;
                            } else {
                                next.add(list.get(i)/list.get(j));
                            }
                        }
                        // 判断剩下的元素是否符合要求
                        if (judge(next)) {
                            return true;
                        }
                        next.removeLast();
                    }
                }
            }
        }
        return false;
    }
}
