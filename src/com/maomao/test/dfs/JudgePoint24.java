package com.maomao.test.dfs;

import java.util.ArrayList;
import java.util.List;

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
        List<Double> list = new ArrayList<>();
        // '/'不是整除，转为浮点数
        for (int a : nums) {
            list.add((double)a);
        }
        return judge(list);
    }

    private boolean judge(List<Double> list) {
        //没有结果
        if (list.size() == 0) {
            return false;
        }
        // le-6是浮点计算的精度误差，这里判断误差小于1e-6，这样就是正确结果
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }

        for (int i=0; i< list.size() ;i++) {
            for (int j=0; j<list.size(); j++) {
                if (i != j) {
                    //保存计算以后的数
                    List<Double> list1 = new ArrayList<>();
                    for (int k=0; k<list.size(); k++) {
                        if (k!=i && k!=j) {
                            list1.add(list.get(k));
                        }
                    }
                    //4中情况计算i和j
                    for (int n=0; n<4; n++) {
                        if (n==0) {
                            list1.add(list.get(i) - list.get(j));
                        } else if (n==1) {
                            list1.add(list.get(i) * list.get(j));
                        } else if (n==2) {
                            list1.add(list.get(i) + list.get(j));
                        } else {
                            //除法为0
                            if (Math.abs(list.get(j)) < 1e-6) {
                                continue;
                            } else {
                                list1.add(list.get(i)/list.get(j));
                            }
                        }
                        // 在这次计算后，判断剩下的元素是否符合要求
                        // 每次缩小计算范围
                        if (judge(list1)) {
                            return true;
                        }
                        // 回溯方法，移除最后一个计算结果，因为最后的记过不满足要求
                        list1.remove(list1.size() - 1);
                    }
                }
            }
        }
        return false;
    }

}
