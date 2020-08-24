/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._53_MaximumSubarray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _53_MaximumSubarray
 * @author lilin
 * @date 2020-8-24 15:16
 */
public class _053_MaximumSubarray {

	/*
	给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

	示例:
	
	输入: [-2,1,-3,4,-1,2,1,-5,4]
	输出: 6
	解释:连续子数组[4,-1,2,1] 的和最大，为6。
	进阶:
	
	如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/maximum-subarray
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	 */

	// time : O(n) space : O(n);
	public static int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			//要想和最大，那么dp[i-1]就不能是负数
			dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	// time : O(n) space : O(1);
	public static int maxSubArray2(int[] nums) {
		int res = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			res = Math.max(res, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray2(nums));
	}
}
