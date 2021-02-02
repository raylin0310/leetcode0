/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._283_MoveZeroes
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 移动零
 * @author lilin
 * @date 2020-9-3 14:48
 */
public class _283_MoveZeroes {
	/*
	给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

	示例:

	输入: [0,1,0,3,12]
	输出: [1,3,12,0,0]
	说明:

	必须在原数组上操作，不能拷贝额外的数组。
	尽量减少操作次数。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/move-zeroes
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	 題解：经典双指针，跟027题一样
	 */

	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				AU.swap(nums, i, j++);
			}
		}
	}


	public static void moveZeroes2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[start++] = nums[i];
			}
		}
		while (start < nums.length) {
			nums[start++] = 0;
		}
	}


	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		AU.print(nums);
	}
}
