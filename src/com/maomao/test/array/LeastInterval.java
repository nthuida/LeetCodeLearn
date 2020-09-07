package com.maomao.test.array;

/**
 * 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 *
 *
 * 示例 ：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *
 * @author huida
 * @date 2020/9/4
 */
public class LeastInterval {

    /**
     * 摆放顺序：先摆放任务个数多的，从上到下，从左到右摆放
     * 执行顺序：左到右，上到下
     *
     * 最短时间：在填不满桶时，最短时间为 (n + 1) * (max - 1) + maxCount；在桶放不下时，最短时间是tasks.length。综合起来就是它两的最大值
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] task = new int[26];
        //转化
        for (char ch : tasks) {
            task[ch - 'A']++;
        }
        int max = 0;
        for (int a : task) {
            if (a > max) {
                max = a;
            }
        }
        int maxCount = 0;
        for (int count : task) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max((n + 1) * (max - 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(new LeastInterval().leastInterval(tasks, 2));
    }
}
