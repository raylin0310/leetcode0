/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._209_MinimumSizeSubarraySum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * _209_MinimumSizeSubarraySum
 * @author lilin
 * @date 2020-8-24 17:40
 */
public class _209_MinimumSizeSubarraySum {
	/*
	给定一个含有n个正整数的数组和一个正整数s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。


	示例：
	
	输入：s = 7, nums = [2,3,1,2,4,3]
	输出：2
	解释：子数组[4,3]是该条件下的长度最小的子数组。
	
	
	进阶：
	
	如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路见网站
	 */

	public static int minSubArrayLen1(int s, int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		int[] sums = new int[n + 1];
		// 为了方便计算，令 size = n + 1
		// sums[0] = 0 意味着前 0 个元素的前缀和为 0
		// sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
		// 以此类推
		for (int i = 1; i <= n; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}
		for (int i = 1; i <= n; i++) {
			int target = s + sums[i - 1];
			int bound = Arrays.binarySearch(sums, target);
			if (bound < 0) {
				bound = -bound - 1;
			}
			if (bound <= n) {
				ans = Math.min(ans, bound - (i - 1));
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE;
		int left = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (left <= i && sum >= s) {
				res = Math.min(res, i - left + 1);
				sum -= nums[left++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;

	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 2, 4, 3};
		//System.out.println(minSubArrayLen(7, nums));
		System.out.println(minSubArrayLen1(7, nums));
	}
}
