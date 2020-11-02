/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._167_TwoSum2InputArrayIsSorted
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 两数之和 II - 输入有序数组
 * @author lilin
 * @date 2020-11-2 15:54
 */
public class _167_TwoSum2InputArrayIsSorted {
	/*
	给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。

	函数应该返回这两个下标值 index1 和 index2，其中 index1必须小于index2。
	
	说明:
	
	返回的下标值（index1 和 index2）不是从零开始的。
	你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
	示例:
	
	输入: numbers = [2, 7, 11, 15], target = 9
	输出: [1,2]
	解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
		思路：双指针
		time: O(n)
		space: O(1)
	 */

	public static int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			if (numbers[left] + numbers[right] == target) {
				return new int[]{left + 1, right + 1};
			} else if (numbers[left] + numbers[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return new int[]{-1, -1};
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		AU.print(twoSum(nums, 9));
	}
}
