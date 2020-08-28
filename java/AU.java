/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.ArrayUtil
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * ArrayUtil
 * @author lilin
 * @date 2020-8-13 10:47
 */
public class AU {

	public static void toString(int[][] nums) {
		for (int[] num : nums) {
			toString(num);
			System.out.println();
		}
	}

	public static void toString(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) {
				System.out.print(nums[i] + "\n");
			} else {
				System.out.print(nums[i] + "\t");
			}
		}
	}
}
