/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._120_Triangle
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形最小路径和
 * @author lilin
 * @date 2020-12-18 10:48
 */
public class _120_Triangle {
	/*

	给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行Triangle中相邻的结点上。

	相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。



	例如，给定三角形：

	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

	说明：
	如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
	 */

	// 10,6,13,10
	public static int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] f = new int[n][n];
		f[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; ++i) {
			// 第一个
			f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
			for (int j = 1; j < i; ++j) {
				f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
			}
			// 最后一个
			f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
		}
		int minTotal = f[n - 1][0];
		for (int i = 1; i < n; ++i) {
			minTotal = Math.min(minTotal, f[n - 1][i]);
		}
		return minTotal;
	}


	/*
		 [-1],[2,3],[1,-1,-3]
         [1,2],[1,-1,-3]
         [2,0,-1]
         优化空间，在计算dp[j]的时候，我们只用到了上一层的dp数据，只需要2ms
	     time : O(n^2)
         space : O(n)
	 */

	public static int minimumTotal2(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n];
		// 处理第一层
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			List<Integer> cur = triangle.get(i);
			int pre = dp[0];
			// 处理第开头
			dp[0] = pre + cur.get(0);
			// 因为是三角形，所以i和j的最大值是相等的，即第n层有n个数字，这里只处理去除开头和末尾，中间的数据
			// 这里还有个优化办法，就是j从后往前遍历参考方法3
			for (int j = 1; j < i; j++) {
				int temp = dp[j];
				dp[j] = Math.min(pre, dp[j]) + cur.get(j);
				pre = temp;
			}
			// 处理末尾
			dp[i] = pre + cur.get(i);
		}
		int min = Integer.MAX_VALUE;
		for (int i : dp) {
			min = Math.min(i, min);
		}
		return min;
	}

	public static int minimumTotal3(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n];
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < n; ++i) {
			// 处理末尾
			dp[i] = dp[i - 1] + triangle.get(i).get(i);
			for (int j = i - 1; j > 0; j--) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
			}
			// 处理开头
			dp[0] += triangle.get(i).get(0);
		}
		int minTotal = dp[0];
		for (int i = 1; i < n; ++i) {
			minTotal = Math.min(minTotal, dp[i]);
		}
		return minTotal;
	}

	// 逆向
	public static int minimumTotal4(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(-1);
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(2);
		row2.add(3);
		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(1);
		row3.add(-1);
		row3.add(-3);
		ArrayList<Integer> row4 = new ArrayList<>();
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		//triangle.add(row4);
		System.out.println(minimumTotal(triangle));
		System.out.println(minimumTotal2(triangle));
		System.out.println(minimumTotal3(triangle));
	}
}
