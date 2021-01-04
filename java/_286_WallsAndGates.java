/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._286_WallsAndGates
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 墙与门
 * @author lilin
 * @date 2021-1-4 17:41
 */
public class _286_WallsAndGates {
	/*
	你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：

	-1 表示墙或是障碍物
	0 表示一扇门
	INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
	你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。


	这道题类似一种迷宫问题，规定了 -1 表示墙，0表示门，让求每个点到门的最近的曼哈顿距离，这其实类似于求距离场 Distance Map 的问题，那么先考虑用 DFS 来解，
	思路是，搜索0的位置，每找到一个0，以其周围四个相邻点为起点，开始 DFS 遍历，并带入深度值1，
	如果遇到的值大于当前深度值，将位置值赋为当前深度值，并对当前点的四个相邻点开始DFS遍历，
	注意此时深度值需要加1，这样遍历完成后，所有的位置就被正确地更新了，参见代码如下：
	 */

	public void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, i, j, 0);
				}
			}
		}
	}

	private void dfs(int[][] rooms, int i, int j, int dis) {
		//  rooms[i][j] < dis 表示，ij可能是墙，或者是之前被标记过了
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < dis) {
			return;
		}
		rooms[i][j] = dis;
		dfs(rooms, i - 1, j, dis + 1);
		dfs(rooms, i + 1, j, dis + 1);
		dfs(rooms, i, j + 1, dis + 1);
		dfs(rooms, i, j - 1, dis + 1);
	}
}
