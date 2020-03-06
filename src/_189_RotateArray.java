/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._189_RotateArray
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * _189_RotateArray
 * @author lilin
 * @date 2020-3-6 11:02
 */
public class _189_RotateArray {
/*
	Given an array, rotate the array to the right by k steps, where k is non-negative.

	Example 1:

	Input: [1,2,3,4,5,6,7] and k = 3
	Output: [5,6,7,1,2,3,4]
	Explanation:
	rotate 1 steps to the right: [7,1,2,3,4,5,6]
	rotate 2 steps to the right: [6,7,1,2,3,4,5]
	rotate 3 steps to the right: [5,6,7,1,2,3,4]

	Example 2:

	Input: [-1,-100,3,99] and k = 2
	Output: [3,99,-1,-100]
	Explanation:
	rotate 1 steps to the right: [99,-1,-100,3]
	rotate 2 steps to the right: [3,99,-1,-100]
	Note:

	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
	Could you do it in-place with O(1) extra space?
*/

	/*
	[1,2,3,4,5,6,7]  k = 3

	[5,6,7,1,2,3,4]
	*/

	public void rotate(int[] nums, int k) {
		if (k < 1) {
			return;
		}
		k = k % nums.length;
		for (int i = 0; i < k; i++) {
			int num0 = nums[nums.length - 1];
			int pre = nums[0];
			for (int j = 0; j < nums.length - 1; j++) {
				int temp = nums[j + 1];
				nums[j + 1] = pre;
				pre = temp;
			}
			nums[0] = num0;
		}
	}

	public void rotate2(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				// 计数，解决循环移动问题，如length = 6,k =2
				count++;
			} while (start != current);
		}

	}

	/**
	 * step1: [7,6,5,4,3,2,1]
	 * step2: [5,6,7,4,3,2,1]
	 * step3: [5,6,7,1,2,3,4]
	 */
	public void rotate3(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		_189_RotateArray test = new _189_RotateArray();
		test.rotate(nums, k);
		System.out.println(Arrays.toString(nums));
	}

}
