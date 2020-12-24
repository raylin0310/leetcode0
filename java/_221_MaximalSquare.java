/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._221_MaximalSquare
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最大正方形
 * @author lilin
 * @date 2020-12-24 19:19
 */
public class _221_MaximalSquare {
	/*
	在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
	看官方题解吧。。。

	 time : O(m * n)
     space : O(m * n)
	 */

	public int maximalSquare(char[][] matrix) {
		int maxSide = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return maxSide;
		}
		int rows = matrix.length, columns = matrix[0].length;
		int[][] dp = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						// 如果当前是1，那么左、左上、上，应该都是1
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					}
					maxSide = Math.max(maxSide, dp[i][j]);
				}
			}
		}
		return maxSide * maxSide;
	}
}
