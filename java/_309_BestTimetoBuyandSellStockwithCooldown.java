/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._309_BestTimetoBuyandSellStockwithCooldown
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _309_BestTimetoBuyandSellStockwithCooldown
 * @author lilin
 * @date 2020-5-9 13:39
 */
public class _309_BestTimetoBuyandSellStockwithCooldown {
/*
	给定一个整数数组，其中第i个元素代表了第i天的股票价格 。

	设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

	你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
	示例:

	输入: [1,2,3,0,2]
	输出: 3
	解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

	*/




	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0){
			return 0;
		}
		int n = prices.length;
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			//如果今天是现金状态，1、昨天是现金状态，今天不操作，2、昨天是股票状态，今天选择卖出
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			//如果今天是股票状态，1、昨天是股票状态，今天不操作，2、昨天是现金状态，今天买入，因为题目要求卖出后，第二天不能买入
			//那么如果今天要买入，昨天结束前（就等于前天的状态）就不能是股票状态，昨天结束前不能是股票状态，等于前天结束后应该是现金状态
			dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
		}
		return dp[n - 1][0];
	}

	//上面的空间优化版本
	public static int maxProfit2(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		int dp_pre_0 = 0; // 代表 dp[i-2][0]
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			// 今天持有，一是昨天就持有，今天继承昨天的；二是昨天买入，昨天买入，那前天就不能卖出，前天处于现金状态，那昨天的现金就等于前天的现金，
			// 那利润就是前天的现金减去昨天买股票的价格
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println(maxProfit(prices));
	}

}
