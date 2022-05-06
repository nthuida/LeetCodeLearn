package com.maomao.test.array;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @author huida
 * @date 2020/6/23
 */
public class GenerateMatrix {

    /**
     * 定义当前左右上下边界 l,r,t,b，初始值 num = 1，迭代终止值 tar = n * n；
     * 当 num <= tar 时，始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环，每次填入后：
     * 执行 num += 1：得到下一个需要填入的数字；
     * 更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int left = 0, right=n-1, top=0, bottom = n-1;
        int[][] res = new int[n][n];
        int end = n*n;
        int start = 1;
        while (start <= end) {
            for (int i=left; i<=right; i++) {
                //从左到右
                res[top][i] = start++;
            }
            //向下一行
            top++;
            for (int i = top; i<=bottom; i++) {
                //从上到下
                res[i][right] = start++;
            }
            //向左一列
            right--;
            for (int i= right; i>=left; i--) {
                //从右往左
                res[bottom][i] = start++;
            }
            //向上一行
            bottom--;
            for (int i=bottom; i>=top; i--) {
                res[i][left] = start++;
            }
            //向右一列
            left++;
        }
        return res;
    }

}
