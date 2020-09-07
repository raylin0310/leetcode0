/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._34_FindFirstAndLastPositionOfElementInSortedArray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _34_FindFirstAndLastPositionOfElementInSortedArray
 * @author lilin
 * @date 2020-9-7 15:28
 */
public class _034_FindFirstAndLastPositionOfElementInSortedArray {
	/*
	给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

	你的算法时间复杂度必须是O(log n) 级别。
	
	如果数组中不存在目标值，返回[-1, -1]。
	
	示例 1:
	
	输入: nums = [5,7,7,8,8,10], target = 8
	输出: [3,4]
	示例2:
	
	输入: nums = [5,7,7,8,8,10], target = 6
	输出: [-1,-1]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


	https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/da-jia-bu-yao-kan-labuladong-de-jie-fa-fei-chang-2/
	 */

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}
		int start = findFirst(nums, target);
		if (start == -1) {
			return new int[]{-1, -1};
		}
		int end = findLast(nums, target);
		return new int[]{start, end};
	}

	public static int findFirst(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				// ① 不可以直接返回，应该继续向左边找，即 [left, mid - 1] 区间里找
				right = mid - 1;
			} else if (nums[mid] < target) {
				// 应该继续向右边找，即 [mid + 1, right] 区间里找
				left = mid + 1;
			} else {
				// 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
				right = mid - 1;
			}
		}

		// 此时 left 和 right 的位置关系是 [right, left]，注意上面的 ①，此时 left 才是第 1 次元素出现的位置
		// 因此还需要特别做一次判断
		if (left != nums.length && nums[left] == target) {
			return left;
		}
		return right;
	}

	public static int findLast(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				// 只有这里不一样：不可以直接返回，应该继续向右边找，即 [mid + 1, right] 区间里找
				left = mid + 1;
			} else if (nums[mid] < target) {
				// 应该继续向右边找，即 [mid + 1, right] 区间里找
				left = mid + 1;
			} else {
				// 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
				right = mid - 1;
			}
		}
		// 由于 findFirstPosition 方法可以返回是否找到，这里无需单独再做判断
		return right;
	}

	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] nums2 = {1};
		int[] nums3 = {5, 7, 7, 8, 8, 10};
		AU.print(searchRange(nums3, 6));
	}
}
