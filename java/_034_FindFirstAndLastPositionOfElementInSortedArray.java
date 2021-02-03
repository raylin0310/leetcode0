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

	二分搜索 左闭右开 建议看这篇文章https://www.zhihu.com/question/36132386
	对求边界的二分查找，用左闭右开更好，因为跳出循环的时候，left==right，不用再考虑用left还是right
	如果求具体的某个值，用左闭右闭更好

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
		int l = 0;
		int r = nums.length;

		while (l < r) {
			int mid = l + (r - l) / 2;

			if (nums[mid] == target) {
				r = mid;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else if (nums[mid] > target) {
				r = mid;
			}
		}
		// target 比所有数都大
		if (l == nums.length) {
			return -1;
		}
		return nums[l] == target ? l : -1;
	}

	public static int findLast(int[] nums, int target) {
		int left = 0;
		int right = nums.length;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				left = mid + 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid;
			}
		}
		/*
		跟寻找左侧边界不同的时，假如target 比所有数都大，那么left最后位置是n，
		因为我们对 left 的更新必须是 left = mid + 1，就是说 while 循环结束时，nums[left] 一定不等于 target 了，而 nums[left-1] 可能是 target。
		 */

		if (left == 0) {
			return -1;
		}
		return nums[left - 1] == target ? (left - 1) : -1;
	}

	public static void main(String[] args) {
		int[] nums1 = {5, 7, 7, 8, 8, 10};

		System.out.println(findLast(nums1, 90));

	}
}
