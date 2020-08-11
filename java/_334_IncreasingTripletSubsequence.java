/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._334_IncreasingTripletSubsequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _334_IncreasingTripletSubsequence
 * @author lilin
 * @date 2020-5-11 17:45
 */
public class _334_IncreasingTripletSubsequence {
/*
	给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

	数学表达式如下:

	如果存在这样的i, j, k,  且满足0 ≤ i < j < k ≤ n-1，
	使得arr[i] < arr[j] < arr[k] ，返回 true ;否则返回 false 。
	说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

	示例 1:

	输入: [1,2,3,4,5]
	输出: true
	示例 2:

	输入: [5,4,3,2,1]
	输出: false
	*/

	public static boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE;
		int mid = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= small) {
				small = num;
			} else if (num < mid) {
				mid = num;
			} else if (num > mid) {
				return true;
			}
		}

		return false;
	}


	/**

	  1,2,3,7,5

	 */

	public static void main(String[] args) {
		int[] nums = {3,5,1,2,3};
		System.out.println(increasingTriplet(nums));
	}

}
