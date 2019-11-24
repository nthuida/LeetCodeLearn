package com.maomao.test.array;

/**
 * @author Administrator
 * @date 2019/5/22
 */
public class Matrix {
    /**
     * 转圈打印矩阵
     *   1  2  3  4
     *   5  6  7  8
     *   9  10 11 12
     *   13 14 15 16
     *   结果：1,2,3,4,8,12,16,15，14,13,9,5,6,7,11,10
     * @param matrix
     */
    public void spiralOrderPrint(int[][] matrix) {
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int leftUpRow = 0;
        int leftUpColumn = 0;
        while (leftUpRow <= row && leftUpColumn <= column) {
            print(matrix, leftUpRow++, leftUpColumn++, row--, column--);
        }
    }

    /**
     * 打印外环矩阵:每次打印四个边
     * @param matrix
     * @param leftUpRow
     * @param leftUpColumn
     * @param rightDownRow
     * @param rightDownColumn
     */
    public void print(int[][] matrix, int leftUpRow, int leftUpColumn, int rightDownRow, int rightDownColumn) {
        if (leftUpRow == rightDownRow) {
            //只有一行
            for (int i=leftUpColumn; i<=rightDownColumn; i++) {
                System.out.print(matrix[leftUpRow][i] + " ,");
            }
        } else if (leftUpColumn == rightDownColumn) {
            //只有一列
            for (int i =leftUpRow; i<=rightDownRow; i++) {
                System.out.print(matrix[i][leftUpColumn] + " ,");
            }
        } else {
            int tempRow = leftUpRow;
            int tempColumn = leftUpColumn;
            //上边
            while (tempColumn != rightDownColumn) {
                System.out.print(matrix[leftUpRow][tempColumn++] + " ,");
            }
            //右边
            while (tempRow != rightDownRow) {
                System.out.print(matrix[tempRow++][rightDownColumn] + " ,");
            }
            //下边
            while (tempColumn != leftUpColumn) {
                System.out.print(matrix[rightDownRow][tempColumn--] + " ,");
            }
            //左边
            while (tempRow != leftUpRow) {
                System.out.print(matrix[tempRow--][leftUpColumn] + " ,");
            }
        }
    }

    /**
     * 对角线打印矩阵：从左上角开始
     *  1  2  3  4
     *  5  6  7  8
     *  9  10 11 12
     *  13 14 15 16
     *
     *  结果：1,5,2,9,6,3,13,10,7,4,14,11,8,15,12,16
     * @param matrix
     */
    public void leftPrint(int[][] matrix) {
        int n = matrix.length;
        //打印左上部分
        for (int i = 0; i < n; i++){
            int row = i;
            int col = 0;
            while (row >= 0 && col <= i){
                System.out.print(matrix[row][col] + ",");
                row--;
                col++;
            }
        }
        //打印右下
        for (int j = 1; j < n; j++){
            int row  = n-1;
            int col = j;
            while (row > 0 && col < n){
                System.out.print(matrix[row][col] + ",");
                row--;
                col++;
            }
        }
    }

    /**
     * 对角线打印，右上角开始
     * @param matrix
     */
    public void rightPrint(int[][] matrix) {
        // 打印右上部分
        int n = matrix.length;
        for (int i = n - 1; i >= 0; i--) {
            int row = 0;
            int col = i;
            while ((row >= 0 && row < n) && (col >= 0 && col < n)) {
                System.out.print(matrix[row][col] + ",");
                row++;
                col++;
            }
        }

        // 打印左下部分
        for (int i = 1; i < n; i++) {
            int row = i;
            int col = 0;
            while ((row >= 0 && row < n) && (col >= 0 && col < n)) {
                System.out.print(matrix[row][col] + ",");
                row++;
                col++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6 ,7,8}, {9,10,11,12},{13,14,15,16}};
        new Matrix().spiralOrderPrint(matrix);
        new Matrix().leftPrint(matrix);
        new Matrix().rightPrint(matrix);
    }
}
