/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._131_PalindromePartitioning
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * @author lilin
 * @date 2020-10-19 10:43
 */
public class _131_PalindromePartitioning {
	
	/*
	给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

	返回 s 所有可能的分割方案。
	
	示例:
	
	输入:"aab"
	输出:
	[
	  ["aa","b"],
	  ["a","a","b"]
	]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/palindrome-partitioning
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	回溯
	time: O(2^n) space O(n)
	 */

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		helper(res, new ArrayList<>(), s);
		return res;
	}

	/*
	 这里可以优化，传一个int start，然后isPalindrome改为（string s,int left,int right），这样子每次就不用截取字符串了
	 if (isPalindrome(s.substring(0, i + 1))) -> if (isPalindrome(s,start,i)) {
	 */

	public static void helper(List<List<String>> res, List<String> list, String s) {
		if (s.length() == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i + 1))) {
				list.add(s.substring(0, i + 1));
				helper(res, list, s.substring(i + 1));
				list.remove(list.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		ArrUtil.print(partition("a"));
		System.out.println("a".substring(1)); // ""
	}
}
