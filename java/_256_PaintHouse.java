/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._256_PaintHouse
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 粉刷房子
 * @author lilin
 * @date 2020-12-22 10:05
 */
public class _256_PaintHouse {
	/*
	假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。

	当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。

	例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。

	注意：

	所有花费均为正整数。
	 */

	/*
	  time : O(n)
      space : O(1)
	 */

	public static int minCost(int[][] costs) {
		int n = costs.length;
		for (int i = 1; i < n; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}
		return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
	}

	//下面这种不会修改原二维数组

	public static int minCost2(int[][] costs) {
		int n = costs.length;
		int pre0 = costs[0][0];
		int pre1 = costs[0][1];
		int pre2 = costs[0][2];
		for (int i = 1; i < n; i++) {
			int temp0 = costs[i][0] + Math.min(pre1, pre2);
			int temp1 = costs[i][1] + Math.min(pre0, pre2);
			int temp2 = costs[i][2] + Math.min(pre0, pre1);
			pre0 = temp0;
			pre1 = temp1;
			pre2 = temp2;
		}
		return Math.min(Math.min(pre0, pre1), pre2);
	}

	public static void main(String[] args) {
		int[][] costs = new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
		System.out.println(minCost(costs));
		int[][] costs2 = new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
		System.out.println(minCost2(costs2));
	}
}
