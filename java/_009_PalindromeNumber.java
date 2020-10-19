/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._009_PalindromeNumber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 回文数
 * @author lilin
 * @date 2020-9-27 14:52
 */
public class _009_PalindromeNumber {
	/*
	判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

	示例 1:
	
	输入: 121
	输出: true
	示例2:
	
	输入: -121
	输出: false
	解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
	示例 3:
	
	输入: 10
	输出: false
	解释: 从右向左读, 为 01 。因此它不是一个回文数。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/palindrome-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

		266一模一样的题
	 */

	public static boolean isPalindrome(int x) {

		if (x < 0 || x != 0 && x % 10 == 0) {
			return false;
		}
		int palind = x;
		int rev = 0;
		while (x > 0) {
			rev = rev * 10 + x % 10;
			x /= 10;
		}
		return palind == rev;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(1331));
	}
}
