/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._070_ClimbingStairs
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 爬楼梯
 * @author lilin
 * @date 2020-12-17 13:52
 */
public class _070_ClimbingStairs {
	/*
	假设你正在爬楼梯。需要 n阶你才能到达楼顶。

	每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	
	注意：给定 n 是一个正整数。
	
	示例 1：
	
	输入： 2
	输出： 2
	解释： 有两种方法可以爬到楼顶。
	1.  1 阶 + 1 阶
	2.  2 阶
	示例 2：
	
	输入： 3
	输出： 3
	解释： 有三种方法可以爬到楼顶。
	1.  1 阶 + 1 阶 + 1 阶
	2.  1 阶 + 2 阶
	3.  2 阶 + 1 阶
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/climbing-stairs
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	爬楼梯进阶版
	 */
	// time : O(n)
	// space : O(n)
	public static int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	/*
	内化优化版
	 */

	public static int climbStairs3(int n) {
		if (n <= 2) {
			return n;
		}
		int pp = 1;
		int p = 2;
		for (int i = 3; i <= n; i++) {
			int res = p+pp;
			pp = p;
			p = res;
		}
		return p;
	}

	//space : O(n1)
	public static int climbStairs2(int n) {
		if (n <= 2) {
			return n;
		}
		int oneStep = 1, twoStep = 1, res = 0;
		for (int i = 2; i <= n; i++) {
			res = oneStep + twoStep;
			twoStep = oneStep;
			oneStep = res;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(26));
		System.out.println(climbStairs3(26));
	}
}
