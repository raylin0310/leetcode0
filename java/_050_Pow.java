/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._050_Pow
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _050_Pow
 * @author lilin
 * @date 2020-10-26 14:00
 */
public class _050_Pow {
	/*
	实现pow(x, n)，即计算 x 的 n 次幂函数。

	示例 1:
	
	输入: 2.00000, 10
	输出: 1024.00000
	示例2:
	
	输入: 2.10000, 3
	输出: 9.26100
	示例3:
	
	输入: 2.00000, -2
	输出: 0.25000
	解释: 2-2 = 1/22 = 1/4 = 0.25
	说明:
	
	-100.0 <x< 100.0
	n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/powx-n
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 time : O(logn);
     space : O(logn)

	思路：快速幂 + 递归
	https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
	 */

	public static double myPow1(double x, int n) {
		if (n > 0) {
			return pow(x, n);
		} else {
			return 1.0 / pow(x, n);
		}
	}

	public static double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		// 比如 n=4，那么 ans = x^2 * x^2 = x^4
		// 比如 n=5 那么 ans = x^2 * x^2 * x = x^5
		double y = pow(x, n / 2);
		if (n % 2 == 0) {
			return y * y;
		} else {
			return y * y * x;
		}
	}

	/*
	 迭代版本
	 */

	public static double myPow2(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double res = 1;
		long abs = Math.abs(n);
		while (abs > 0) {
			if (abs % 2 != 0) {
				res *= x;
			}
			x *= x;
			abs /= 2;
		}
		if (n < 0) {
			return 1.0 / res;
		}
		return res;
	}


	public static void main(String[] args) {
		System.out.println(myPow1(2, 3));
		System.out.println(myPow2(2, 3));
	}
}
