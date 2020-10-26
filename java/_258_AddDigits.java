/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._258_AddDigits
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 各位相加
 * @author lilin
 * @date 2020-10-23 10:10
 */
public class _258_AddDigits {
	/*
	给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

	示例:

	输入: 38
	输出: 2
	解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于2 是一位数，所以返回 2。
	进阶:
	你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/add-digits
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int addDigits(int num) {
		while (num > 9) {
			int sum = 0;
			while (num != 0) {
				sum += num % 10;
				num /= 10;
			}
			num = sum;
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(addDigits(10));
	}

}
