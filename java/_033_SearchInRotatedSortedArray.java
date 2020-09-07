/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._33_SearchInRotatedSortedArray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 搜索旋转排序数组
 * @author lilin
 * @date 2020-9-7 10:35
 */
public class _033_SearchInRotatedSortedArray {
	/*
	假设按照升序排序的数组在预先未知的某个点上进行了旋转。

	( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
	
	搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
	
	你可以假设数组中不存在重复的元素。
	
	你的算法时间复杂度必须是O(logn) 级别。
	
	示例 1:
	
	输入: nums = [4,5,6,7,0,1,2], target = 0
	输出: 4
	示例2:
	
	输入: nums = [4,5,6,7,0,1,2], target = 3
	输出: -1
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */


	public static int search(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = (r - l) / 2 + l;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[l] <= nums[mid]) {
				//左侧是有序
				if (target >= nums[l] && target < nums[mid]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			if (nums[mid] <= nums[r]) {
				//右侧是有序的
				if (target > nums[mid] && target <= nums[l]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(search(nums, 0));
		System.out.println(search(nums, 3));
	}
}
