package com.maomao.test.array;

/**
 * 删除排序数组中的重复项

 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * @author Administrator
 * @date 2019/3/20
 */
public class RemoveDuplicates {
    /**
     * 采用两个标记点 number 和 i ，number记录不重复元素的位置，i从number的下一个开始遍历数组，如果i位置的数字等于number位置的数字，
     * 说明该数字重复出现，不予处理；如果i位置的数字不等于number位置的数字，说明该数字没有重复，需要放到l的下一位置，并使number加1。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int number = 0;
        for(int i =0; i<nums.length;i++){
            // 相邻两个值比较，不同才做统计操作
            if(nums[i]!=nums[number]){
                number++;
                nums[number] = nums[i];
            }
        }
        // 不同数字为总量= number+1
        number += 1;
        return number;
    }

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1:
     *
     * 给定 nums = [3,2,2,3], val = 3,
     *
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int number = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] != val){
                nums[number] = nums[i];
                number++;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[] ints = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDuplicates().removeDuplicates(ints));
        for (int i=0;i<ints.length;i++) {
            System.out.println(ints[i]);
        }
        System.out.println();

        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(new RemoveDuplicates().removeElement(nums, 2));
        for (int i=0; i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
