/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._081_SearchInRotatedSortedArrayII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 搜索旋转排序数组 II
 * @author lilin
 * @date 2020-9-7 11:08
 */
public class _081_SearchInRotatedSortedArrayII {
	/*
	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	
	( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。
	
	编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。
	
	示例1:
	
	输入: nums = [2,5,6,0,0,1,2], target = 0
	输出: true
	示例2:
	
	输入: nums = [2,5,6,0,0,1,2], target = 3
	输出: false
	进阶:
	
	这是 搜索旋转排序数组的延伸题目，本题中的nums 可能包含重复元素。
	这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 跟33题不同的时，33题是没有重复的，比如5,10,5,5,5,5 ，target=10，中位数1和最左侧数1是相等的，
	 那么我们该取左半部分还是右半部分呢？只需要让left++，然后继续循环即可
	 */

	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[start] == nums[mid]) {
				start++;
				continue;
			}
			//前半部分有序
			if (nums[mid] > nums[start]) {
				//target在前半部分
				if (target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {  //否则，去后半部分找
					start = mid + 1;
				}
			} else {
				//后半部分有序
				//target在后半部分
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {  //否则，去后半部分找
					end = mid - 1;

				}
			}
		}
		//一直没找到，返回false
		return false;

	}

	public static void main(String[] args) {
		int[] nums = {1, 0, 1, 1, 1};
		System.out.println(search(nums, 0));
	}
}
