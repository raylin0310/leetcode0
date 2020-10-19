/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._005_LongestPalindromicSubstring
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最长回文子串
 * @author lilin
 * @date 2020-9-27 11:14
 */
public class _005_LongestPalindromicSubstring {
	/*
	
	给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。

	示例 1：
	
	输入: "babad"
	输出: "bab"
	注意: "aba" 也是一个有效答案。
	示例 2：
	
	输入: "cbbd"
	输出: "bb"
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/longest-palindromic-substring
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路：动态规划
	 */

	// time : O(n^2) space : O(n^2);

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String res = "";
		boolean[][] dp = new boolean[s.length()][s.length()];
		int max = 0;
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i <= j; i++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
				if (dp[i][j]) {
					if (j - i + 1 > max) {
						max = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res;
	}

	// time : O(n^2) space : O(1)

	public static String longestPalindrome2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			res = helper(res,s, i, i);
			res = helper(res,s, i, i + 1);
		}
		return res;
	}
	public static String helper(String res,String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		String cur = s.substring(left + 1, right);
		if (cur.length() > res.length()) {
			res = cur;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome2("babad"));
	}
}
