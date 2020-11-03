/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._259_3SumSmaller
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * 较小的三数之和
 * @author lilin
 * @date 2020-11-3 10:09
 */
public class _259_3SumSmaller {
	/*
	给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组 i, j, k 个数（0 <= i < j < k < n）。
	 */

	public int threeSumSmaller(int[] nums, int target) {
		int res = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] < target) {
					res += right - left;
					left++;
				} else {
					right--;
				}
			}
		}

		return res;
	}
}
