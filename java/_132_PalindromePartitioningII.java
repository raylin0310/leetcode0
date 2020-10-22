/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._132_PalindromePartitioningII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 分割回文串 II
 * @author lilin
 * @date 2020-10-20 10:25
 */
public class _132_PalindromePartitioningII {
	/*
	给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

	返回符合要求的最少分割次数。
	
	示例:
	
	输入:"aab"
	输出: 1
	解释: 进行一次分割就可将s 分割成 ["aa","b"] 这样两个回文子串。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	解题思路：动态规划
	cuts[i]表示前缀子串 s[0:i] 分割成若干个回文子串所需要最小分割次数。

	time : O(n^2)
    space : O(n^2)
	 */

	public static int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		//也是dp
		int[] cuts = new int[len];
		//isPalindrome[a][b]表示s[a,b]，a是index小的
		boolean[][] isPalindrome = new boolean[len][len];


		for (int i = 0; i < s.length(); i++) {
			// min表示最小切割次数，默认为i，表示最坏情况下，每个单词切割一次
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
					isPalindrome[j][i] = true;
					/*
					cuts[j - 1] + 1 表达的意思:
					假如i=10,j=6，那么s[6,10]这一子串是回文子串，那么只需要从j=6切一刀，前面的s[0,6]的切割次数是cuts[j - 1]
					所以总的切割次数是cuts[j - 1] + 1
					 */
					min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
				}
			}
			cuts[i] = min;
		}
		return cuts[len - 1];
	}

	public static void main(String[] args) {
		System.out.println(minCut("abbab"));
	}
}
