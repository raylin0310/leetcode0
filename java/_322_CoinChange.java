/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._322_CoinChange
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * 零钱兑换
 * @author lilin
 * @date 2020-12-21 14:12
 */
public class _322_CoinChange {
	/*
	给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
	
	你可以认为每种硬币的数量是无限的。

	输入：coins = [1, 2, 5], amount = 11
	输出：3 
	解释：11 = 5 + 5 + 1

	输入：coins = [2], amount = 3
	输出：-1

	输入：coins = [1], amount = 0
	输出：0

	输入：coins = [1], amount = 1
	输出：1

	输入：coins = [1], amount = 2
	输出 2
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/coin-change
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 min = Math.min(min, dp[i - coins[j]] + 1);
	 此题类似于第279题
	 */

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		if (coins == null || coins.length == 0) {
			return -1;
		}
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i >= coin && dp[i - coin] != -1) {
					// dp[0] 表示coin刚好等于需要的钱
					min = Math.min(min, dp[i - coin] + 1);
				}
			}
			dp[i] = min == Integer.MAX_VALUE ? -1 : min;
		}
		return dp[amount];
	}


	public static void main(String[] args) {
		int[] coins = {2, 2, 5};
		System.out.println(coinChange(coins, 3));
	}

	/*
	贪心 + dfs
	https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/

	优先丢大硬币进去尝试，也没必要一个一个丢，可以用乘法算一下最多能丢几个

	k = amount / coins[c_index] 计算最大能投几个
	amount - k * coins[c_index] 减去扔了 k 个硬币
	count + k 加 k 个硬币

	如果因为丢多了导致最后无法凑出总额，再回溯减少大硬币数量

	最先找到的并不是最优解

	考虑到有 [1,7,10] 这种用例，按照贪心思路 10 + 1 + 1 + 1 + 1 会比 7 + 7 更早找到

	所以还是需要把所有情况都递归完
	 */

	static class Solution {
		int res = Integer.MAX_VALUE;

		public int coinChange(int[] coins, int amount) {
			if (amount == 0) {
				return 0;
			}
			Arrays.sort(coins);
			dfs(coins, amount, coins.length - 1, 0);
			return res == Integer.MAX_VALUE ? -1 : res;
		}

		private void dfs(int[] coins, int amount, int index, int count) {
			// 这里一定要先判断amount== 0，在判断index，
			if (amount == 0) {
				res = Math.min(res, count);
				return;
			}
			if (index < 0) {
				return;
			}
			//i + count < res 提请剪枝，如果当前coin分成的个数i加上已经分了的个数count 小于等于 res，才继续，不然没必要
			for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
				dfs(coins, amount - (i * coins[index]), index - 1, count + i);
			}
		}
	}
}
