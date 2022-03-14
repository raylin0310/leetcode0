/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._349_IntersectionOfTwoArrays
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;
import java.util.HashSet;

/**
 * 两个数组的交集
 * @author lilin
 * @date 2020-9-8 10:34
 */
public class _349_IntersectionOfTwoArrays {
	/*
	给定两个数组，编写一个函数来计算它们的交集。

	示例 1：
	
	输入：nums1 = [1,2,2,1], nums2 = [2,2]
	输出：[2]
	示例 2：
	
	输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	输出：[9,4]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	//平均情况下，time: O(n+m)，space:O(n+m)

	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[]{};
		}
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> ret = new HashSet<>();
		for (Integer num : nums1) {
			set.add(num);
		}
		for (Integer num : nums2) {
			if (set.contains(num)) {
				ret.add(num);
			}

		}
		int k = 0;
		int[] res = new int[ret.size()];
		for (Integer num : ret) {
			res[k++] = num;
		}
		return res;
	}

	// Arrays.sort time : O(nlogn+mlogm) space : O(logn+logm);
	//如果数组都是有序的话，这种方法要好
	public static int[] intersection2(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[]{};
		}
		HashSet<Integer> set = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		int k = 0;
		int[] res = new int[set.size()];
		for (Integer num : set) {
			res[k++] = num;
		}
		return res;
	}

	// binary search time : O(nlogn) space : O(n)
	public static int[] intersection3(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[]{};
		}
		HashSet<Integer> set = new HashSet<>();
		Arrays.sort(nums2);
		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {
				set.add(num);
			}
		}
		int k = 0;
		int[] res = new int[set.size()];
		for (Integer num : set) {
			res[k++] = num;
		}
		return res;
	}

	public static boolean binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target) {
				return true;
			} else if (nums[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] == target || nums[end] == target) return true;
		return false;
	}

	public static void main(String[] args) {
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};
		ArrUtil.print(intersection(nums1, nums2));
	}
}
