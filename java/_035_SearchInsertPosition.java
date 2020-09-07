/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._35_SearchInsertPosition
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 搜索插入位置
 * @author lilin
 * @date 2020-9-7 10:19
 */
public class _035_SearchInsertPosition {
	/*
	给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

	你可以假设数组中无重复元素。
	
	示例 1:
	
	输入: [1,3,5,6], 5
	输出: 2
	示例2:
	
	输入: [1,3,5,6], 2
	输出: 1
	示例 3:
	
	输入: [1,3,5,6], 7
	输出: 4
	示例 4:
	
	输入: [1,3,5,6], 0
	输出: 0
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/search-insert-position
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = (r - l) / 2 + l;
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		int[] nums2 = {5, 7, 9, 10};
		System.out.println(searchInsert(nums2, 2));
	}
}
