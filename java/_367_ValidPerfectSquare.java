/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._367_ValidPerfectSquare
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 有效的完全平方数
 * @author lilin
 * @date 2020-10-26 16:15
 */
public class _367_ValidPerfectSquare {
	/*
	给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

	说明：不要使用任何内置的库函数，如 sqrt。
	
	示例 1：
	
	输入：16
	输出：True
	示例 2：
	
	输入：14
	输出：False
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/valid-perfect-square
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	// time : O(logn) space : O(1)
	public static boolean isPerfectSquare2(int num) {
		int left = 0;
		int right = num;
		while (left <= right) {
			long mid = (right - left) / 2 + left;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				left = (int) mid + 1;
			} else {
				right = (int) mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare2(5));
	}
}
