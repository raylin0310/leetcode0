/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._265_PaintHouseII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 粉刷房子2
 * @author lilin
 * @date 2020-12-22 10:13
 */
public class _265_PaintHouseII {
	/*
	假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。

	当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。

	例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；
	costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。

	注意：

	所有花费均为正整数。

	示例：

	输入: [[1,5,3],[2,9,4]]
	输出: 5
	解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5;
	     或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5.
	进阶：
	您能否在 O(nk) 的时间复杂度下解决此问题？
	 */

	/*
	 下面两种写法的复杂度是一样的，第二种不会修改原二维数组，更优秀
	 time : O(n * k)
     space : O(1)
	 */

	public static int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int n = costs.length;
		int k = costs[0].length;

		int min1 = -1, min2 = -1;
		for (int i = 0; i < n; i++) {
			// last1是前一层最小的，last2是第二小的
			int last1 = min1, last2 = min2;
			min1 = -1;
			min2 = -1;
			for (int j = 0; j < k; j++) {
				// 这里算法的意思，如果当前不是前一层最小的下标(满足相邻层不能同色)，那么当前j最小的cos就是加上前一层最小的,即last1
				// 如果当前跟前一轮是同色的话，就加上第二小的，即last2
				// 有点贪心算法的意思，要想costs[i][j]最小，那么前一层costs[i-1][x]必须最小，这里的x满足不等于j（不同色）并且整个值要最小
				// 如果x=j,那么就取costs[i-1]第二小的
				if (j != last1) {
					costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
				} else {
					costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
				}
				// min1<0是为了初始化这一层最小的，当j=0时，必走下面，也就是min1=0,min2=-1
				// 后面的意思是，如果j的值小于前面最小的了，那么新的最小值min1就是j，第二最小值min2就是min1
				if (min1 < 0 || costs[i][j] < costs[i][min1]) {
					min2 = min1;
					min1 = j;
				} else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
					// 如果不满足上面的，那么久同第二小的比较，即如果min1 < j < min2的话，那么j就是第二小的，即min2
					// min2 < 0的意思是，只计算了min1，还没有min2的情况，就初始化min2
					// 如costs[i]=[5,8,9],那么第一轮时，min1=0,min2=-1，第二轮的时候走下面，min2=1
					min2 = j;
				}
			}
		}
		return costs[n - 1][min1];
	}

	// 思路同上，这个不会修改原数组，因为这个直接用min1、min2保存值，idx1表示最小的下标，更优

	public static int minCostII2(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int n = costs.length;
		int k = costs[0].length;
		// min1、min2上一层最小的两个数，idx1表示上一层最小数的index
		int min1 = 0, min2 = 0, idx1 = -1;
		for (int i = 0; i < n; ++i) {
			// 这一层最小的两个数和最小数的下标
			int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, id1 = -1;
			for (int j = 0; j < k; j++) {
				int cost = costs[i][j] + (j == idx1 ? min2 : min1);
				if (cost <= m1) {
					m2 = m1;
					m1 = cost;
					id1 = j;
				} else if (cost <= m2) {
					m2 = cost;
				}
			}
			min1 = m1;
			min2 = m2;
			idx1 = id1;
		}
		return min1;
	}

	public static void main(String[] args) {
		int[][] costs = new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}, {2, 5, 6}, {8, 9, 2}, {10, 20, 30}, {40, 60, 32}, {4, 5, 6}, {9, 8, 5}};
		System.out.println(minCostII(costs));
		int[][] costs2 = new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}, {2, 5, 6}, {8, 9, 2}, {10, 20, 30}, {40, 60, 32}, {4, 5, 6}, {9, 8, 5}};
		System.out.println(minCostII2(costs2));

	}
}
