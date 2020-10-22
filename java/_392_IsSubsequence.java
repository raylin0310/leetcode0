/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._392_IsSubsequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 *  判断子序列
 * @author lilin
 * @date 2020-10-22 9:59
 */
public class _392_IsSubsequence {
	/*
	给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

	你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
	
	字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
	
	示例1:
	s = "abc", t = "ahbgdc"
	
	返回true.
	
	示例2:
	s = "axc", t = "ahbgdc"
	
	返回false.
	
	后续挑战 :
	
	如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/is-subsequence
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static boolean isSubsequence(String s, String t) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Deque<Character> q = new LinkedList();
		for (char c : s.toCharArray()) {
			q.add(c);
		}
		for (char c : t.toCharArray()) {
			if (q.peekFirst().equals(c)) {
				q.pollFirst();
				if (q.isEmpty()){
					return true;
				}
			}
		}
		return q.isEmpty();
	}
	/*
		双指针
		time:O(n+m)
		space:O(1)
	 */

	public static boolean isSubsequence2(String s, String t) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == s.length();
	}
	// dp
	public static boolean isSubsequence3(String s, String t) {
		int n = s.length(), m = t.length();

		int[][] f = new int[m + 1][26];
		for (int i = 0; i < 26; i++) {
			f[m][i] = m;
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < 26; j++) {
				//t.charAt(i) 当前字符与j相等，那么下一次跳跃就是当前
				if (t.charAt(i) == j + 'a') {
					f[i][j] = i;
				} else {
					f[i][j] = f[i + 1][j];
				}
			}
		}
		int add = 0;
		for (int i = 0; i < n; i++) {
			if (f[add][s.charAt(i) - 'a'] == m) {
				return false;
			}
			add = f[add][s.charAt(i) - 'a'] + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		//System.out.println(isSubsequence("axc","ahbgdc"));
		System.out.println(isSubsequence3("abc","ahbgdc"));
	}
}
