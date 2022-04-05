package com.maomao.test.sort;

/**
 * @author Administrator
 * @date 2019/3/14
 */
public class Sort {
    /**
     * 冒泡排序
     * 基本思想：每一轮两两比较交换，将最大值冒泡到最后一位
     * 复杂度：O(n^2)
     * @param array
     */
    public void bubbleSort(int[] array) {
        int len = array.length;
        //外围两两比较的次数
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 基本思想：每一轮找到数组未排序部分的最小值交换至数组未排序部分首位
     * 复杂度：O(n^2)
     * @param array
     */
    public void selectSort(int[] array) {
        int len = array.length;
        for (int i=0; i<len-1; i++) {
            int minIndex = i;
            //在[i+1, len-1]未排序的数组中，寻找最小值
            for (int j=i+1; j<len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //交换元素
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     * 插入排序
     * 基本思路：从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置
     * 复杂度：O(N^2)
     * @param array
     */
    public void insertionSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            // 记录要插入的数据
            int tmp = array[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    //后移
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            // 插入
            array[j+1] = tmp;
        }
    }

    /**
     * 快排
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
     * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,
     * 然后再用同样的方法递归地排序划分的两部分。
     * 复杂度：O(NlogN)
     * @param array
     */
    public void quickSort(int[] array) {
        sort(array, 0, array.length-1);
    }

    public void sort(int[] array, int low, int high) {
        if (low < high) {
            //递归退出标志
            int mid = getMid(array, low, high);
            sort(array, low, mid-1);
            sort(array, mid+1, high);
        }
    }

    public int getMid(int[] array, int low, int high) {
        //基准元素
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        //中间元素和位置
        array[low] = temp;
        return low;
    }

    /**
     * 归并排序
     * 基本思想：先拆分，再合并
     * 复杂度：O(NlogN)
     * @param array
     */
    public void mergeSort(int[] array) {
        sortII(array, 0, array.length-1);
    }

    private void sortII(int[] array, int start, int end) {
        if (start < end) {
            int mid = start + (end-start)/2;
            sortII(array, start, mid);
            sortII(array, mid+1, end);
            //合并
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[array.length];
        int index = start;
        int leftBegin = start;
        int rightBegin = mid +1;
        while (leftBegin <= mid && rightBegin<= end) {
            if (array[leftBegin] < array[rightBegin]) {
                temp[index++] = array[leftBegin++];
            } else {
                temp[index++] = array[rightBegin++];
            }
        }
        //左边的还有
        while (leftBegin <= mid) {
            temp[index++] = array[leftBegin++];
        }

        //右边的还有
        while (rightBegin <= end) {
            temp[index++] = array[rightBegin++];
        }
        //复制到原数组
        for (int i=start; i<=end; i++) {
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] a = {3,43,2,56,7};
        sort.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();

        int[] a1 = {13,43,22,56,71};
        sort.quickSort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }

        System.out.println();

        int[] a2 = {3,8,22,6,11};
        sort.mergeSort(a2);
        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i]);
        }

        System.out.println();

        int[] a3 = {3,9,2,6,11};
        sort.insertionSort(a3);
        for (int i = 0; i < a3.length; i++) {
            System.out.println(a3[i]);
        }
    }
}
