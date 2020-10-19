/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._214_ShortestPalindrome
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最短回文串
 * @author lilin
 * @date 2020-9-27 15:02
 */
public class _214_ShortestPalindrome {
	/*
	给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

	示例1:
	
	输入: "aacecaaa"
	输出: "aaacecaaa"
	示例 2:
	
	输入: "abcd"
	输出: "dcbabcd"
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/shortest-palindrome
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	// time :  O(n^2) for aaaaabcaaaaa
	public static String shortestPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		int end = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				i = 0;
				end--;
				j = end;
			}
		}
		return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
	}

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abcd"));
	}
}
