/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._003_SubstringWithConcatenationOfAllWords
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * @author lilin
 * @date 2020-9-24 10:02
 */
public class _003_SubstringWithConcatenationOfAllWords {
	/*
	给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

	示例1:
	
	输入: "abcabcbb"
	输出: 3 
	解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	示例 2:
	
	输入: "bbbbb"
	输出: 1
	解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
	示例 3:
	
	输入: "pwwkew"
	输出: 3
	解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
	    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路：滑动窗口
	 */

	// 滑动窗口思路
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() <1) {
			return 0;
		}
		HashSet<Character> set = new HashSet<>();
		int rk = -1;
		int n = s.length();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				//左指针向右移动，移除前面的字符
				set.remove(s.charAt(i - 1));
			}
			while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
				//右指针不断向右移动
				set.add(s.charAt(rk + 1));
				rk++;
			}
			max = Math.max(rk - i + 1, max);
		}
		return max;
	}
	// 思路跟上面一样，如果遇到重复的，就取前面重复字符指针的下一位作为新的左指针
	// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
	public static int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			res = Math.max(res, i - j + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		//System.out.println(lengthOfLongestSubstring("pwwkew"));
		//System.out.println(lengthOfLongestSubstring("au"));
		//System.out.println(lengthOfLongestSubstring("aab"));
		System.out.println(lengthOfLongestSubstring2("dvdf"));
	}
}
