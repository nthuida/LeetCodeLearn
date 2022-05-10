package com.maomao.test.array;

/**
 * 航班预定统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 
 * 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 *
 * 示例 1：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 *
 * 示例 2：
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 *
 * @author: huida
 * @date: 2022/5/10
 **/
public class CorpFlightBookings {

    /**
     * 差分数组
     * 差分数组的前缀和等于原数组
     * 对arr[i ... j]区间每个元素全部增加delta
     * 等价于：diff[i] += delta，diff[j+1] -= delta
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //差分数组
        int[] diff = new int[n+1];
        for (int[] booking : bookings) {
            //增量
            int add = booking[2];
            //下标从0开始
            diff[booking[0]-1] += add;
            diff[booking[1]-1+1] -= add;
        }
        //原数组
        int[] res = new int[n];
        res[0] = diff[0];
        //差分数组前缀和等于原数组
        for (int i=1; i<n; i++) {
            res[i] = diff[i] + res[i-1];
        }
        return res;
    }

    /**
     * 拼车
     * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
     * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 
     * 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。
     * 这些位置是从汽车的初始位置向东的公里数。
     * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
     *
     * 示例 1：
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
     * 输出：false
     *
     * 示例 2：
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
     * 输出：true
     *
     * 0 <= fromi < toi <= 1000
     *
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        //差分数组，共有1001站
        int[] diff = new int[1001];
        //[from, to-1]需要累加
        for (int[] trip: trips) {
            int add = trip[0];
            diff[trip[1]] += add;
            diff[trip[2]-1+1] -= add;
        }
        if (diff[0] >capacity) {
            return false;
        }
        //原数组
        int[] res = new int[1001];
        res[0] = diff[0];
        for (int i=1; i<1001; i++) {
            res[i] = diff[i] + res[i-1];
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
