/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._695_MaxAreaOfIsland
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 *  岛屿的最大面积
 * @author lilin
 * @date 2021-1-4 16:37
 */
public class _695_MaxAreaOfIsland {
	/*
	这个题解太棒辣
	https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
	 */

	public static int maxAreaOfIsland(int[][] grid) {
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int a = area(grid, i, j);
				res = Math.max(res, a);
			}
		}
		return res;
	}

	public static int area(int[][] grid, int r, int c) {
		if (!inArea(grid, r, c)) {
			return 0;
		}
		if (grid[r][c] != 1) {
			return 0;
		}
		grid[r][c] = 2;
		return 1 + area(grid, r - 1, c)
				+ area(grid, r + 1, c)
				+ area(grid, r, c - 1)
				+ area(grid, r, c + 1);
	}

	public static boolean inArea(int[][] grid, int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
	}

}
