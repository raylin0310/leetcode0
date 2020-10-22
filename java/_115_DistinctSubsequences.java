/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._115_DistinctSubsequences
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 不同的子序列(不会)
 * @author lilin
 * @date 2020-10-22 10:48
 */
public class _115_DistinctSubsequences {
	/*
	给定一个字符串S和一个字符串T，计算在 S 的子序列中 T 出现的个数。

	一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
	
	题目数据保证答案符合 32 位带符号整数范围。

	示例1：
	
	输入：S = "rabbbit", T = "rabbit"
	输出：3
	解释：
	
	如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
	(上箭头符号 ^ 表示选取的字母)
	
	rabbbit
	^^^^ ^^
	rabbbit
	^^ ^^^^
	rabbbit
	^^^ ^^^
	示例2：
	
	输入：S = "babgbag", T = "bag"
	输出：5
	解释：
	
	如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
	(上箭头符号 ^ 表示选取的字母)
	
	babgbag
	^^ ^
	babgbag
	^^    ^
	babgbag
	^    ^^
	babgbag
	  ^  ^^
	babgbag
	    ^^^
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/distinct-subsequences
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	https://leetcode-cn.com/problems/distinct-subsequences/solution/pythonti-jie-yi-kan-jiu-dong-de-fen-xi-yao-yao-yao/
	设定dp[i][j]为使用s的前i个字符能够最多组成多少个t的前j个字符
	 */

	public static int numDistinct(String S, String T) {
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		for (int i = 0; i < S.length(); i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[S.length()][T.length()];
	}

	public static void main(String[] args) {
		System.out.println(numDistinct("abcc","abc"));
	}
}
