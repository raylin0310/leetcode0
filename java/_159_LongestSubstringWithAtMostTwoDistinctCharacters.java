/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._159_LongestSubstringWithAtMostTwoDistinctCharacters
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;

/**
 * _159_LongestSubstringWithAtMostTwoDistinctCharacters
 * @author lilin
 * @date 2020-9-27 10:36
 */
public class _159_LongestSubstringWithAtMostTwoDistinctCharacters {
	/*
		输入一个字符串，要求返回最长的substring，使得substring最多只有两个不同的字符。
		For example, Given s = “eceba”,

         T is "ece" which its length is 3.

         跟340题一样
	 */

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0;
		int res = 0;
		while (end < s.length()) {
			if (map.size() <= 2) {
				map.put(s.charAt(end), end);
				end++;
			}
			if (map.size() > 2) {
				int leftMost = s.length();
				for (int num : map.values()) {
					leftMost = Math.min(leftMost, num);
				}
				map.remove(s.charAt(leftMost));
				start = leftMost + 1;
			}
			res = Math.max(res, end - start);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(_340_LongestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("eceba",2));
	}
}
