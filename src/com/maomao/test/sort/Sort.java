package com.maomao.test.sort;

/**
 * @author Administrator
 * @date 2019/3/14
 */
public class Sort {
    /**
     * 冒泡排序
     * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
     * 让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     * @param arrary
     */
    public static void bubbleSort(int[] arrary) {
        int len = arrary.length;
        int temp;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (arrary[j] > arrary[j+1]) {
                    temp = arrary[j+1];
                    arrary[j+1] = arrary[j];
                    arrary[j] = temp;
                }
            }
        }
    }

    /**
     * 快排
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
     * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     * @param arrary
     */
    public static void quickSort(int[] arrary) {
        sort(arrary, 0, arrary.length-1);
    }

    public static void sort(int[] arrary, int low, int high) {
        if (low < high) {
            //递归退出标志
            int mid = getMid(arrary, low, high);
            sort(arrary, low, mid-1);
            sort(arrary, mid+1, high);
        }
    }

    public static int getMid(int[] arrary, int low, int high) {
        //基准元素
        int temp = arrary[low];
        while (low < high) {
            while (low < high && arrary[high] > temp) {
                high--;
            }
            arrary[low] = arrary[high];
            while (low < high && arrary[low] < temp) {
                low++;
            }
            arrary[high] = arrary[low];
        }
        //中间元素和位置
        arrary[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {3,43,2,56,7};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        int[] a1 = {13,43,22,56,71};
        quickSort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }
    }
}
