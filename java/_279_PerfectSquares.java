/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._279_PerfectSquares
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * 完全平方数
 * @author lilin
 * @date 2020-12-18 15:02
 */
public class _279_PerfectSquares {
	/*
	给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

	示例1:
	
	输入: n = 12
	输出: 3 
	解释: 12 = 4 + 4 + 4.
	示例 2:
	
	输入: n = 13
	输出: 2
	解释: 13 = 4 + 9.
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/perfect-squares
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				int m1 = dp[i];
				// +1 是因为要算上j,比如 13 - 3*3 = 4（2*2） 那么个数就是1(3)+1(2) = 2
				int m2 = dp[i - j * j] + 1;
				dp[i] = Math.min(m1, m2);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		//3
		System.out.println(numSquares(12));
		//2
		//System.out.println(numSquares(13));
	}
}
