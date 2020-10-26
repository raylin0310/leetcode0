/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._007_ReverseInteger
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 整数反转
 * @author lilin
 * @date 2020-10-22 11:23
 */
public class _007_ReverseInteger {
	/*
	给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

	示例1:
	
	输入: 123
	输出: 321
	示例 2:
	
	输入: -123
	输出: -321
	示例 3:
	
	输入: 120
	输出: 21
	注意:
	
	假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−2^31, 2^31− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-integer
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
		}
		return (int) res;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
}
