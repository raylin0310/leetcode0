/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._325_MaximumSizeSubarraySumEqualsK
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;

/**
 * _325_MaximumSizeSubarraySumEqualsK
 * @author lilin
 * @date 2020-8-24 15:50
 */
public class _325_MaximumSizeSubarraySumEqualsK {

	/*
	给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。

	注意:
	 nums 数组的总和是一定在 32 位有符号整数范围之内的。

	示例 1:

	输入: nums = [1, -1, 5, -2, 3], k = 3
	输出: 4
	解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
	示例 2:

	输入: nums = [-2, -1, 2, 1], k = 1
	输出: 2
	解释: 子数组 [-1, 2] 和等于 1，且长度最长。
	进阶:
	你能使时间复杂度在 O(n) 内完成此题吗?
	 */
	/*
		前缀和：什么是前缀和？前缀和是一个数组的某项下标之前(包括此项元素)的所有数组元素的和。
		a[]表示原数组，b[]表示前缀和数组
		a[i]=b[i]-b[i-1]
		a[i+1]=b[i+1]-b[i]

		sum[i,i+1] = b[i+1] - b[i-1]

		sum[i,j]   = b[j]   - b[i-1]
		那么
		sum[i+1,j] = b[j] - b[i]   length = j - (i+1) + 1 = j - i

	 */

	/*
	扩展：前缀和还可以用作其他类型的题
	1、给定一个数组，数组中只包含0和1。请找到一个最长的子序列，其中0和1的数量是相同的
		可以把为0的变为-1，那么这道题的解就是求和为0的最长子数组
	2、求一个数组中奇数和偶数 数量相等的最长子数组
		同上，可以把偶数变为1，奇数变为-1
	 */

	public static int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		// put0是为了刚好[0,i]的和等于k
		map.put(0, -1);

		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - k)) {
				res = Math.max(res, i - map.get(nums[i] - k));
			}
			map.putIfAbsent(nums[i],i);
		}
		return res;
	}

	public static void main(String[] args) {
		//[1, -1, 5, -2]
		int[] nums = {1, -1, 5, -2, 3};
		int[] nums2 = {-1,1,-1,1,-1,1,-1,1};
		System.out.println(maxSubArrayLen(nums2, 0));
	}

}
