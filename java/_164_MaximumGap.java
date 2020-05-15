/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._164_MaximumGap
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _164_MaximumGap
 * @author lilin
 * @date 2020-5-13 20:21
 */
public class _164_MaximumGap {
/*
	给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

	如果数组元素个数小于 2，则返回 0。

	示例 1:

	输入: [3,6,9,1]
	输出: 3
	解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
	示例 2:

	输入: [10]
	输出: 0
	解释: 数组元素个数小于 2，因此返回 0。
	说明:

	你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
	请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。

	*/

	public static int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2){
			return 0;
		}

		return -1;
	}

}
