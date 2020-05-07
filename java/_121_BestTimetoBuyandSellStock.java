
/**
 * _121_BestTimetoBuyandSellStock
 * @author lilin
 * @date 2020-5-7 15:32
 */
public class _121_BestTimetoBuyandSellStock {
/*
	给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

	如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

	注意：你不能在买入股票前卖出股票。

			 

	示例 1:

	输入: [7,1,5,6,6,4]
	输入: [7,2,8,1,4,4]
	输出: 5
	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
	示例 2:

	输入: [7,6,4,3,1]
	输出: 0
	解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
*/

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int min = prices[0];
		int profit = 0;
		for (int price : prices) {
			min = Math.min(min, price);
			profit = Math.max(profit, price - min);
		}
		return profit;
	}

	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice) {
				minprice = prices[i];
			} else if (prices[i] - minprice > maxprofit) {
				maxprofit = prices[i] - minprice;
			}
		}
		return maxprofit;
	}

	/**
	 * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
	 * 动态规划，棒
	 */

	public static int maxProfit3(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int n = prices.length;
		int[][] dp = new int[n][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		return dp[n - 1][0];
	}


	public static void main(String[] args) {
		int[] nums = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit3(nums));
	}

}
