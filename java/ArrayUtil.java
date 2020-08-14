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
public class ArrayUtil {

	public static void toString(int[][] nums) {
		for (int[] num : nums) {
			toString(num);
			System.out.println();
		}
	}

	public static void toString(int[] nums) {
		for (int num : nums) {
			System.out.print(num + "\t");
		}
	}
}
