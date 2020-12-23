/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._064_MinimumPathSum
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最小路径和
 * @author lilin
 * @date 2020-12-22 14:10
 */
public class _064_MinimumPathSum {
	/*
	给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

	说明：每次只能向下或者向右移动一步。
	
	输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
	输出：7
	解释：因为路径 1→3→1→1→1 的总和最小。
	示例 2：
	
	输入：grid = [[1,2,3],[4,5,6]]
	输出：12

	提示：
	
	m == grid.length
	n == grid[i].length
	1 <= m, n <= 200
	0 <= grid[i][j] <= 100
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/minimum-path-sum
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		// 初始化第一排和第一列
		for (int i = 1; i < n; i++) {
			dp[0][i] = grid[0][i] + dp[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m - 1][n - 1];
	}

	// 滚动数组，参考62题，space:O(n) time:O(n*m)
	// 注意这题和前面两题的不同，前面是求路径有多少种，这题是求数字和

	public static int minPathSum2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[] dp = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					// 计算第一列，等于当前num+上一层num，即g[i][j]+dp[0]
					dp[j] = grid[i][j] + dp[j];
					continue;
				}
				if (i == 0) {
					// 计算第一排，等于当前num+前面num和，即g[i][j]+dp[j-1]
					dp[j] = grid[i][j] + dp[j - 1];
					continue;
				}
				dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);

			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println(minPathSum(grid));
		System.out.println(minPathSum2(grid));
	}
}
