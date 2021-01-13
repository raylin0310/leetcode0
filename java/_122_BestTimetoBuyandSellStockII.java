
/**
 * _122_BestTimetoBuyandSellStockII
 * @author lilin
 * @date 2020-5-7 16:03
 */
public class _122_BestTimetoBuyandSellStockII {
	/*
		给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。

		设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

		注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

		与121题不同的是，可以多次买卖，即买-卖-买-卖

		示例 1:

		输入: [7,1,5,3,6,4]
		输出: 7
		解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
				    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
		示例 2:

		输入: [1,2,3,4,5]
		输出: 4
		解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
				    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
				    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
		示例3:

		输入: [7,6,4,3,1]
		输出: 0
		解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。


		提示：
		1 <= prices.length <= 3 * 10 ^ 4
		0 <= prices[i]<= 10 ^ 4
	*/

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	/*
	 * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
	 *  泛化的动态规划
	 * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
	 *
	 *  动态规划，容易理解
	 *
	 */

	public static int maxProfit2(int[] prices) {
		int len = prices.length;
		if (len < 2) {
			return 0;
		}

		// 0：持有现金
		// 1：持有股票
		// 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
		int[][] dp = new int[len][2];

		dp[0][0] = 0;
		dp[0][1] = -prices[0];

		for (int i = 1; i < len; i++) {
//			解释：今天我没有持有股票，有两种可能：
//			要么是我昨天就没有持有，要么是我昨天持有股票，但是今天我 sell 了
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//			解释：今天我持有着股票，有两种可能：
//			要么我昨天就持有着股票，要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
		}
		return dp[len - 1][0];
	}

	/*
	 上面的空间优化版本，因为今天的数值只与昨天的有关，与昨天之前的数据无关
	 */

	public static int maxProfit3(int[] prices) {
		int len = prices.length;
		if (len < 2) {
			return 0;
		}
		// 0：持有现金
		// 1：持有股票
		int dp0 = 0;
		int dp1 = -prices[0];

		for (int i = 1; i < len; i++) {
			int preDp0 = dp0;
			dp0 = Math.max(dp0, dp1 + prices[i]);
			dp1 = Math.max(dp1, preDp0 - prices[i]);
		}
		return dp0;
	}
	//空间优化版本2
	public static int maxProfit4(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int profit0 = 0, profit1 = -prices[0];
		int length = prices.length;
		for (int i = 1; i < length; i++) {
			int newProfit0 = Math.max(profit0, profit1 + prices[i]);
			int newProfit1 = Math.max(profit1, profit0 - prices[i]);
			profit0 = newProfit0;
			profit1 = newProfit1;
		}
		return profit0;
	}


	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit2(prices));
		System.out.println(maxProfit3(prices));
	}

}
