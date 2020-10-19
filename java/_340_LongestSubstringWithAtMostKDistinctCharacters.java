/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._340_LongestSubstringWithAtMostKDistinctCharacters
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;

/**
 * 最长最多K个无重复字符的字符串长度
 * @author lilin
 * @date 2020-9-25 9:56
 */
public class _340_LongestSubstringWithAtMostKDistinctCharacters {
	/*
	给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。

	示例 1:

	输入: s = "eceba", k = 2
	输出: 3
	解释: 则 T 为 "ece"，所以长度为 3。
	1
	2
	3
	示例 2:

	输入: s = "aa", k = 1
	输出: 2
	解释: 则 T 为 "aa"，所以长度为 2。

	思路：滑动窗口 sliding window

	 time : O(n)  最坏情况O(2n) = O(n)
     space : O(1)
	*/

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}
		int n = s.length();
		int left = 0;
		int max = Integer.MIN_VALUE;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.size() > k && left < i) {
				map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
				Integer leftCharNum = map.get(s.charAt(left));
				if (leftCharNum == 0) {
					// 如果整个窗口内没有，那就移除，map.size就会减少一个
					map.remove(s.charAt(left));
				}
				left++;

			}
			// k 3
			// aabbccaaddee
			max = Math.max(i - left + 1, max);
		}
		return max;
	}

	// 同上，这里用了一个变量num来记录不重复的字符个数
	public static int lengthOfLongestSubstringKDistinct2(String s, int k) {
		int[] count = new int[256];
		int res = 0, num = 0, j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)]++ == 0) {
				num++;
			}
			if (num > k) {
				while (--count[s.charAt(j++)] > 0) {

				}
				num--;
			}
			res = Math.max(res, i - j + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct2("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("accccaa", 1));
		System.out.println(lengthOfLongestSubstringKDistinct2("accccaa", 1));
	}
}
