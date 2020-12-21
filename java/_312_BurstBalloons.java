/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._312_BurstBalloons
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 戳气球
 * @author lilin
 * @date 2020-12-21 11:39
 */
public class _312_BurstBalloons {
	/*
	有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组nums中。

	现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得nums[left] * nums[i] * nums[right]个硬币。
	这里的left和right代表和i相邻的两个气球的序号。注意当你戳破了气球 i 后，气球left和气球right就变成了相邻的气球。

	求所能获得硬币的最大数量。

	说明:

	你可以假设nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
	0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
	示例:

	输入: [3,1,5,8]
	输出: 167
	解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
	    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/burst-balloons
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int maxCoins(int[] nums) {
		int n = nums.length;
		//可以先将题目中要求的nums[-1] = 1，nums[n] = 1，添加到数组
		int[] arr = new int[n + 2];
		System.arraycopy(nums, 0, arr, 1, n);
		arr[0] = arr[n + 1] = 1;

		//共有气球n个，定义dp[0][n - 1]为（0，n - 1）区间内能够得到的最大值，
		//此处0和n-1均取不到，第0个气球和第n-1个气球都是添加的方便计算
		//dp[0][n - 1]为最后要求的答案，假设最后戳破的气球为第i个，状态转移方程：
		//dp[start][end] = dp[start][i] + dp[i][end] + nums[start] * nums[i] * nums[end]   (start < i < end)
		//从状态转移方程看出，每次需要后面遍历的结果，即dp[start][i]和dp[i][end]，不需要管start前面的值
		int len = n + 2;
		int[][] dp = new int[len][len];
		for (int start = len - 1; start >= 0; start--) {
			for (int end = start; end < len; end++) {
				//对于（start，end）区间气球不够一个的就不用戳了，
				if (end - start < 2) {
					continue;
				}
				//计算最后戳破（start，end）区间下标为i的气球
				for (int i = start + 1; i < end; ++i) {
					dp[start][end] = Math.max(dp[start][end], dp[start][i] + dp[i][end] + arr[start] * arr[i] * arr[end]);
				}
			}
		}
		return dp[0][len - 1];
	}

	public static void main(String[] args) {

	}
}
