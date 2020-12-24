/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._072_EditDistance
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * . 编辑距离
 * @author lilin
 * @date 2020-12-23 11:06
 */
public class _072_EditDistance {
	/*
	给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。

	你可以对一个单词进行如下三种操作：
	
	插入一个字符
	删除一个字符
	替换一个字符
	
	示例1：
	
	输入：word1 = "horse", word2 = "ros"
	输出：3
	解释：
	horse -> rorse (将 'h' 替换为 'r')
	rorse -> rose (删除 'r')
	rose -> ros (删除 'e')
	示例2：
	
	输入：word1 = "intention", word2 = "execution"
	输出：5
	解释：
	intention -> inention (删除 't')
	inention -> enention (将 'i' 替换为 'e')
	enention -> exention (将 'n' 替换为 'x')
	exention -> exection (将 'n' 替换为 'c')
	exection -> execution (插入 'u')
	
	提示：
	
	0 <= word1.length, word2.length <= 500
	word1 和 word2 由小写英文字母组成
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/edit-distance
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	//困难题看不懂，官方有详细题解

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= len2; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[len1][len2];
	}

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}
}
