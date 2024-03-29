/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._188_BestTimetoBuyandSellStockIV
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _188_BestTimetoBuyandSellStockIV
 * @author lilin
 * @date 2020-5-7 18:05
 */
public class _188_BestTimetoBuyandSellStockIV {
/*

	给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

	设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

	注意:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

	与123题不同的时，这里交易限制次数为k次

	示例1:

	输入: [2,4,1], k = 2
	输出: 2
	解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
	示例 2:

	输入: [3,2,6,5,0,3], k = 2
	输出: 7
	解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
	随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
*/

	public static int maxProfit(int maxK, int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][maxK + 1][2];
		for (int i = 0; i < n; i++) {
			for (int k = maxK; k >= 1; k--) {
				if (i == 0) {
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[0];
					continue;
				}
				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}
		}
		return dp[n - 1][maxK][0];
	}

	public static void main(String[] args) {
		int[] prices = {3,2,6,5,0,3};
		int k = 2;
		System.out.println(maxProfit(k, prices));
	}

}
