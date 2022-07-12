package com.maomao.test.greedy;

/**
 * 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * 示例 1:
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 * @author huida
 * @date 2020/9/8
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        //考虑从每一个点出发
        for (int i = 0; i < n; i++) {
            int start = i;
            int remain = gas[i];
            //当前剩余的油能否到达下一个点
            while (remain - cost[start] >= 0) {
                //减去花费的加上新的点的补给
                remain = remain - cost[start] + gas[(start + 1) % n];
                start = (start + 1) % n;
                //start 回到了 i
                if (start == i) {
                    return i;
                }
            }
        }
        return -1;

    }

    /**
     * 如果总油量减去总消耗大于等于零那么一定可以跑完一圈，
     * 因此要跑完一圈就要保证在各个站点的加油站 剩油量 rest[i] = gas[i] - cost[i] >= 0。
     * 局部最优：若当前累加到 j 的和 curSum < 0，起始位置至少要是 j+1 ，因为从 j开始一定不行。
     * 全局最优：找到可以跑一圈的起始位置。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuitII(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int curSum = 0;
        int start = 0;
        for (int i=0; i<n; i++) {
            curSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                //起始位置更新为i+1
                start = i+1;
            }
        }
        //总油量减去总消耗小于0，肯定跑不完
        if (sum < 0) {
            return -1;
        }
        return start;
    }
}
