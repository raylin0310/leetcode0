/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._209_MinimumSizeSubarraySum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

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

	思路见网站,也可以用滑动窗口
	 */

	// 滑动窗口，遇到求连续数组（子串）问题，都可以考虑滑动窗口方法
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
		//System.out.println(minSubArrayLen1(7, nums));
	}
}
