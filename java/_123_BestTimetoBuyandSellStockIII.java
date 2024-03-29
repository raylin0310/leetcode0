

/**
 * _123_BestTimetoBuyandSellStockIII
 * @author lilin
 * @date 2020-5-7 16:19
 */
public class _123_BestTimetoBuyandSellStockIII {
/*
	给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

	设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。

	注意:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

	与122题不同的是，只能完成两笔交易，参考下面链接题解
	https://leetcode-cn.com/circle/article/qiAgHn/


	示例1:

	输入: [3,3,5,0,0,3,1,4]
	输出: 6
	解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
			    随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
	示例 2:

	输入: [1,2,3,4,5]
	输出: 4
	解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
			    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
			    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
	示例 3:

	输入: [7,6,4,3,1]
	输出: 0
	解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
*/

	/*
	 * ...
	 */

	public static int maxProfit(int[] prices) {
		int buy1 = Integer.MIN_VALUE;
		int buy2 = Integer.MIN_VALUE;
		int sell1 = 0;
		int sell2 = 0;
		for (int price : prices) {
			sell2 = Math.max(sell2, buy2 + price);
			buy2 = Math.max(buy2, sell1 - price);
			sell1 = Math.max(sell1, buy1 + price);
			buy1 = Math.max(buy1, -price);
		}
		return sell2;
	}

	/*
	 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	 */

	public static int maxProfit2(int[] prices) {
		int max_k = 2;
		int n = prices.length;
		int[][][] dp = new int[n][max_k + 1][2];
		for (int i = 0; i < n; i++) {
			for (int k = 1; k <= max_k; k++) {
				if (i == 0) {
					/* 处理 base case */
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[i];
					continue;
				}
				//i表示这一条结束时的状态
				//结束如果是现金状态，那么可能为昨天就是现金状态，今天不操作，或者昨天是股票状态今天卖了，次数相同（即第2次买的，这里就是第2次卖）
				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				//结束如果是股票状态，那么可能为昨天就是股票状态，今天不操作，或者昨天是现金状态，今天选择买入，那么“今天买入”就是买入次数+1，今天的买入次数是k，昨天就是k-1
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}
		}
		return dp[n - 1][max_k][0];
	}

	public static void main(String[] args) {
		int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit2(prices));
	}

}
