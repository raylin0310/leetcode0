/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._031_NextPermutation
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 下一个排列
 * @author lilin
 * @date 2020-12-15 10:23
 */
public class _031_NextPermutation {
	/*
	实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

	如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
	
	必须 原地 修改，只允许使用额外常数空间。

	示例 1：
	
	输入：nums = [1,2,3]
	输出：[1,3,2]
	示例 2：
	
	输入：nums = [3,2,1]
	输出：[1,2,3]
	示例 3：
	
	输入：nums = [1,1,5]
	输出：[1,5,1]
	示例 4：
	
	输入：nums = [1]
	输出：[1]

	提示：
	
	1 <= nums.length <= 100
	0 <= nums[i] <= 100
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/next-permutation
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	参考官方题解，说的很明白
	https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/

	[4,5,2,6,3,1]  i=num(2) j=num[3] swap->[4,5,3,6,2,1]->reverse->[4,5,3,1,2,6]
	 */

	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			//从右往左，找到第一个比nums[i]大的数
			while (j > i &&  nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void reverse(int[] nums, int start) {
		int left = start, right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}


	public static void main(String[] args) {
		int[] nums = {1, 5, 1};
		nextPermutation(nums);
		AU.print(nums);
	}
}
