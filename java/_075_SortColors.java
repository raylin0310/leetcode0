/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._75_SortColors
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 颜色分类
 * @author lilin
 * @date 2020-9-1 17:48
 */
public class _075_SortColors {
	/*
	给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

	此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。

	注意:
	不能使用代码库中的排序函数来解决这道题。

	示例:

	输入: [2,0,2,1,1,0]
	输出: [0,0,1,1,2,2]
	进阶：

	一个直观的解决方案是使用计数排序的两趟扫描算法。
	首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
	你能想出一个仅使用常数空间的一趟扫描算法吗？

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/sort-colors
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		// l 表示最后一个0的下一个位置，当下一次的数字是零的时候，就和left交换，并left往后移动一步
		int l = 0;
		int r = nums.length - 1;
		int i = 0;
		while (i <= r) {
			if (nums[i] == 0) {
				AU.swap(nums, i++, l++);
			} else if (nums[i] == 1) {
				i++;
			} else {
				AU.swap(nums, i, r--);
			}
		}
	}


	public static void main(String[] args) {
		int[] nums = {2, 1, 1, 0, 1, 1, 0};
		sortColors(nums);
		AU.print(nums);
	}

}
