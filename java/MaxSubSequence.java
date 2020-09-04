/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.MaxSubSequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最长上升子序列
 * @author lilin
 * @date 2020-9-4 10:35
 */
public class MaxSubSequence {

	public static int longestIncreasingSubsequence(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {10,12,14,16,8,9,20};
		System.out.println(longestIncreasingSubsequence(nums));
	}
}
