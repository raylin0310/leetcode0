/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._280_WiggleSort
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 摆动排序
 * @author lilin
 * @date 2020-9-4 11:12
 */
public class _280_WiggleSort {

	/*
	给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
	nums[0] <= nums[1] >= nums[2] <= nums[3]....

	样例
	给出数组为 nums = [3, 5, 2, 1, 6, 4] 一种输出方案为[1, 6, 2, 5, 3, 4]

		根据题意，摇摆排序的定义有两部分：
		如果i是奇数，nums[i] >= nums[i - 1]
		如果i是偶数，nums[i] <= nums[i - 1]
		所以遍历一遍，将错误的进行调整就可以了

	 */

	public static void wiggleSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
				ArrUtil.swap(nums, i, i - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {3, 5, 6, 5, 8, 9};
		wiggleSort(nums);
		ArrUtil.print(nums);
	}
}
