package com.maomao.test.stack;


import java.util.Stack;

/**
 * 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @author huida
 * @date 2020/6/11
 */
public class DailyTemperatures {

    /**
     * 暴力解
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i=0; i<temperatures.length; i++) {
            for (int j=i+1; j<temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 单调递减栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperaturesII(int[] temperatures) {

        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<len; i++) {
            //栈不为空，且当前元素大于栈顶元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                //栈顶元素出栈
                int index = stack.pop();
                //计算栈顶元素升温的间隔天数，i代表当前第一个温度比他高的时间点
                res[index] = i-index;
            }
            //递减，下标索引入栈
            stack.add(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new DailyTemperatures().dailyTemperaturesII(a);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
