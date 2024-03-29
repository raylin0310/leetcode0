/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._351_AndroidUnlockPatterns
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _351_AndroidUnlockPatterns
 * @author lilin
 * @date 2020-12-17 11:18
 */
public class _351_AndroidUnlockPatterns {

	/*
	这道题乍一看题目这么长以为是一个设计题，其实不是，这道题还是比较有意思的，起码跟实际结合的比较紧密。
	这道题说的是安卓机子的解锁方法，有9个数字键，如果密码的长度范围在 [m, n] 之间，问所有的解锁模式共有多少种，
	注意题目中给出的一些非法的滑动模式。那么先来看一下哪些是非法的，首先1不能直接到3，必须经过2，同理的有4到6，7到9，1到7，2到8，3到9，
	还有就是对角线必须经过5，例如1到9，3到7等。建立一个二维数组 jumps，用来记录两个数字键之间是否有中间键，
	然后再用一个一位数组 visited 来记录某个键是否被访问过，然后用递归来解，先对1调用递归函数，
	在递归函数中，遍历1到9每个数字 next，然后找他们之间是否有 jump 数字，如果 next 没被访问过，
	并且 jump 为0，或者 jump 被访问过，对 next 调用递归函数。数字1的模式个数算出来后，
	由于 1,3,7,9 是对称的，所以乘4即可，然后再对数字2调用递归函数，2,4,6,9 也是对称的，再乘4，
	最后单独对5调用一次，然后把所有的加起来就是最终结果了，参见代码如下：
	 */

	public static int numberOfPatterns(int m, int n) {
		int[][] skip = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
		boolean[] visited = new boolean[10];
		int res = 0;
		for (int i = m; i <= n; i++) {
			res += DFS(visited, skip, 1, i - 1) * 4; // 1, 3, 7, 9
			res += DFS(visited, skip, 2, i - 1) * 4; // 2, 4, 6, 8
			res += DFS(visited, skip, 5, i - 1); // 5
		}
		return res;
	}

	public static int DFS(boolean[] visited, int[][] skip, int cur, int remain) {
		if (remain < 0) return 0;
		if (remain == 0) return 1;
		visited[cur] = true;
		int res = 0;
		for (int i = 1; i <= 9; i++) {
			if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])) {
				res += DFS(visited, skip, i, remain - 1);
			}
		}
		//回溯
		visited[cur] = false;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(numberOfPatterns(1,9));
	}
}
