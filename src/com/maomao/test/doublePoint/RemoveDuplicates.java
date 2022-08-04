package com.maomao.test.doublePoint;

/**
 * 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author Administrator
 * @date 2019/3/20
 */
public class RemoveDuplicates {
    /**
     * 双指针
     * 指针j指向有效数组的最后一个位置, 指针i遍历数组，
     * 只有当 i 所指向的值和 j 不相等，才将 i 的值添加到 j 的下一位置
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //初始位置0
        int j = 0;
        for(int i =0; i<nums.length;i++){
            // 相邻两个值比较，不同才做统计操作
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        // 不同数字为总量
        return j+1;
    }

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1:
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @return
     */
    public int removeDuplicate(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int j = 0;
        int count = 1;
        for(int i =1; i<nums.length;i++){
            // 统计相同的个数
            if (nums[i-1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if(count <= 2){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

}
