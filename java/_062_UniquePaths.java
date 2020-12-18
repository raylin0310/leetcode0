/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._062_UniquePaths
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 不同路径
 * @author lilin
 * @date 2020-12-17 14:18
 */
public class _062_UniquePaths {
	/*
	一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。

	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
	
	问总共有多少条不同的路径？

	输入：m = 3, n = 7
	输出：28
	示例 2：
	
	输入：m = 3, n = 2
	输出：3
	解释：
	从左上角开始，总共有 3 条路径可以到达右下角。
	1. 向右 -> 向右 -> 向下
	2. 向右 -> 向下 -> 向右
	3. 向下 -> 向右 -> 向右
	示例 3：
	
	输入：m = 7, n = 3
	输出：28
	示例 4：
	
	输入：m = 3, n = 3
	输出：6
	
	
	提示：
	
	1 <= m, n <= 100
	题目数据保证答案小于等于 2 * 109
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/unique-paths
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	// time : O(n * m) space : (n * m)

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}


	/*
	 time : O(n * m) space : O(n)  滚动数组

	「滚动数组思想」是一种常见的动态规划优化方法，在我们的题目中已经多次使用到，例如「剑指 Offer 46. 把数字翻译成字符串」、「70. 爬楼梯」等，
	当我们定义的状态在动态规划的转移方程中只和某几个状态相关的时候，就可以考虑这种优化方法，目的是给空间复杂度「降维」。
	如果你还不知道什么是「滚动数组思想」，一定要查阅相关资料进行学习哦。

	作者：LeetCode-Solution
	链接：https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */

	public static int uniquePaths2(int m, int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				//一行一行的计算， dp[i - 1][j] + dp[i][j - 1]  我们只需要左边和上边的数，可以把左边、上边放在一个水平线上(即一维数组)
				// 下面dp[j]表示上边的数，dp[j - 1]表示左边的数，计算完成后，再更新到一维数组的当前位置
				dp[j] = dp[j] + dp[j - 1];
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths2(7, 3));
	}
}
