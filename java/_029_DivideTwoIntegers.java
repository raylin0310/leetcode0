/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._029_DivideTwoIntegers
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 两数相除
 * @author lilin
 * @date 2020-10-26 10:51
 */
public class _029_DivideTwoIntegers {
	/*
	给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

	返回被除数dividend除以除数divisor得到的商。
	
	整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

	示例1:
	
	输入: dividend = 10, divisor = 3
	输出: 3
	解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
	示例2:
	
	输入: dividend = 7, divisor = -3
	输出: -2
	解释: 7/-3 = truncate(-2.33333..) = -2
	
	提示：

	被除数和除数均为 32 位有符号整数。
	除数不为0。
	假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]。本题中，如果除法结果溢出，则返回 231− 1。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/divide-two-integers
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/divide-two-integers
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	https://leetcode-cn.com/problems/divide-two-integers/solution/po-su-de-xiang-fa-mei-you-wei-yun-suan-mei-you-yi-/
	 */

	public static int divide(int dividend, int divisor) {
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = -1;
		}
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		if (ldividend < ldivisor || ldividend == 0) {
			return 0;
		}
		long lres = divide(ldividend, ldivisor);
		int res = 0;
		if (lres > Integer.MAX_VALUE) {
			res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			res = (int) (sign * lres);
		}
		return res;
	}

	/*
	 如 11 /3 = (9+2)/3  = 3+0 = 3
	 */
	private static long divide(long ldividend, long ldivisor) {
		if (ldividend < ldivisor) {
			//有小数了，直接返回0
			return 0;
		}
		long sum = ldivisor;
		long multiple = 1;
		while ((sum + sum) <= ldividend) {
			sum += sum;
			multiple += multiple;
		}
		System.out.println(multiple);
		return multiple + divide(ldividend - sum, ldivisor);
	}

	public static void main(String[] args) {
		System.out.printf("result = %d%n", divide(60, 8));
		System.out.printf("result = %d%n", divide(8, 2));
	}
}
