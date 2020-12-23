/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._063_UniquePathsII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 不同路径 II
 * @author lilin
 * @date 2020-12-18 10:07
 */
public class _063_UniquePathsII {
	/*
	一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

	现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/unique-paths-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		time : O(m * n)
        space : O(n)

        滚动数组
	 */

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int column = obstacleGrid[0].length;
		int[] dp = new int[column];
		dp[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[i].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[j] = 0;
				} else if (j > 0) {
					//j=0时，也就是第一列，只有一种路径
					dp[j] = dp[j] + dp[j - 1];
				}
			}
		}
		return dp[column - 1];
	}

	public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				break;
			}
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(uniquePathsWithObstacles(nums));
		System.out.println(uniquePathsWithObstacles2(nums));
	}
}
