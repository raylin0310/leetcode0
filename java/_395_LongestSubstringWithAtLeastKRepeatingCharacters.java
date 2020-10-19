/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._395_LongestSubstringWithAtLeastKRepeatingCharacters
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;

/**
 * 至少有K个重复字符的最长子串
 * @author lilin
 * @date 2020-9-25 11:15
 */
public class _395_LongestSubstringWithAtLeastKRepeatingCharacters {
	/*
	找到给定字符串（由小写字符组成）中的最长子串 T ，要求T中的每一字符出现次数都不少于 k 。输出 T的长度。

	示例 1:
	
	输入:
	s = "aaabb", k = 3
	
	输出:
	3
	
	最长子串为 "aaa" ，其中 'a' 重复了 3 次。
	示例 2:
	
	输入:
	s = "ababbc", k = 2
	
	输出:
	5
	
	最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */


	/*
	这个问题与一般性的滑动窗口问题最大的不同是：怎样保证滑动窗口能够取到所有可行解？

	解决这个问题的办法是，循环26次，限制滑动窗口内的不同字符数分别i (1~26)个，这样能保证不会漏掉任何一个可行解。
	
	具体来说，每次循环中需要记录滑动窗口内不同字符数diff_count 和出现次数大于等于k 的字符数count。
	逐渐右移右边界，当diff_count 大于i时，也就是滑动窗口内的不同字符数大于当前循环限制的不同字符数，
	就缩减滑动窗口的左边界直到刚好满足diff_count == i。当diff_count == count == i时，
	说明滑动窗口内的每个字符出现次数都大于等于k，此时滑动窗口内的元素就是一个可行解。
	
	时间复杂度O(26 * n) 近似一下也就是O(n)了。
	
	作者：fan-fan-yang-zhou
	链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/c-hua-dong-chuang-kou-jie-fa-by-fan-fan-yang-zhou/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	
	public static int longestSubstring2(String s, int k) {
		int res = 0;
		for (int diff_count_target = 1; diff_count_target <= 26; diff_count_target++) {
			res = Math.max(res, helper(s, k, diff_count_target));
		}
		return res;
	}

	private static int helper(String s, int k, int diff_count_target) {
		int[] count = new int[128];
		int start = 0, end = 0;
		int diff_count  = 0, numNoLessThanK = 0;
		int res = 0;

		while (end < s.length()) {
			if (count[s.charAt(end)]++ == 0) {
				//不同字符的数量
				diff_count ++;
			}
			if (count[s.charAt(end++)] == k) {
				//出现次数不小于K的字符数量
				numNoLessThanK++;
			}

			while (diff_count  > diff_count_target) {
				if (count[s.charAt(start)]-- == k) {
					numNoLessThanK--;
				}
				if (count[s.charAt(start++)] == 0) {
					diff_count --;
				}
			}
			if (diff_count  == diff_count_target && diff_count  == numNoLessThanK) {
				res = Math.max(end - start, res);
			}
		}
		return res;
	}

	//分治,这种好理解
	public static int longestSubstring3(String s, int k) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		ArrayList<Integer> split = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] < k) {
				split.add(i);
			}
		}
		if (split.isEmpty()) {
			return s.length();
		}
		int ans = 0, pre = 0;
		split.add(s.length());
		for (Integer i : split) {
			ans = i > pre ? Math.max(ans, longestSubstring3(s.substring(pre, i), k)) : ans;
			pre = i + 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring3("aaabb", 4));//3
		//System.out.println(longestSubstring3("ababbc", 2));//5
		//System.out.println(longestSubstring3("ababacb", 3));//0
		//System.out.println(longestSubstring3("bbaaacbd", 3));//3
	}
}
