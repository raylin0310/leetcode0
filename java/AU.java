/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.ArrayUtil
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.List;

/**
 * ArrayUtil
 * @author lilin
 * @date 2020-8-13 10:47
 */
public class AU {

	public static void print(List nums) {
		for (Object num : nums) {
			System.out.println(num);
		}
	}

	public static void print(int[][] nums) {
		for (int[] num : nums) {
			print(num);
			System.out.println();
		}
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				System.out.print(nums[i] + "\n");
			} else {
				System.out.print(nums[i] + "\t");
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		if (i == j){
			return;
		}
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
