/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._200_NumberOfIslands
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *  岛屿数量
 * @author lilin
 * @date 2021-1-4 16:52
 */
public class _200_NumberOfIslands {

	/*
	这个题解太棒辣
	https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
	time:O(nm)
	space:O(mn)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达mn。
	 */

	public static int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				res += area(grid, i, j);
			}
		}
		return res;
	}

	/*
	 dfs
	 */

	public static int area(char[][] grid, int r, int c) {
		if (!inArea(grid, r, c)) {
			return 0;
		}
		if (grid[r][c] != '1') {
			return 0;
		}
		// 把走过的岛屿设置成2，避免后续再对这个岛屿重复计算，也避免陷入无限循环绕圈圈
		grid[r][c] = '2';
		area(grid, r - 1, c);
		area(grid, r + 1, c);
		area(grid, r, c - 1);
		area(grid, r, c + 1);
		return 1;
	}

	/*
	 bfs
	 */

	private void bfs(char[][] grid, int i, int j) {
		Queue<int[]> list = new LinkedList<>();
		list.add(new int[]{i, j});
		while (!list.isEmpty()) {
			int[] cur = list.poll();
			i = cur[0];
			j = cur[1];
			if (inArea(grid, i, j)) {
				grid[i][j] = '2';
				list.add(new int[]{i + 1, j});
				list.add(new int[]{i - 1, j});
				list.add(new int[]{i, j + 1});
				list.add(new int[]{i, j - 1});
			}
		}
	}

	public static boolean inArea(char[][] grid, int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
	}
}
