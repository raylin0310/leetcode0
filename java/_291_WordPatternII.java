/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._291_WordPatternII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * 单词规律 II
 * @author lilin
 * @date 2020-12-16 10:21
 */
public class _291_WordPatternII {
	/*
	给你一种规律 pattern 和一个字符串 str，请你判断 str 是否遵循其相同的规律。

	这里我们指的是 完全遵循，例如 pattern 里的每个字母和字符串 str 中每个 非空 单词之间，存在着双向连接的对应规律。

	示例1:
	输入: pattern = "abab", str = "redblueredblue"
	输出: true

	示例2:
	输入: pattern = "aaaa", str = "asdasdasdasd"
	输出: true

	示例3:
	输入: pattern = "aabb", str = "xyzabcxzyabc"
	输出: false

	提示：
	你可以默认 pattern 和 str 都只会包含小写字母。
	 */

	public static boolean wordPatternMatch(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		return isMatch(str, 0, pattern, 0, map, set);
	}

	private static boolean isMatch(String str, int i, String pat, int j, HashMap<Character, String> map, HashSet<String> set) {
		if (i == str.length() && j == pat.length()) {
			return true;
		}
		if (i == str.length() || j == pat.length()) {
			return false;
		}

		char c = pat.charAt(j);
		if (map.containsKey(c)) {
			String s = map.get(c);
			if (!str.startsWith(s, i)) {
				return false;
			}
			return isMatch(str, i + s.length(), pat, j + 1, map, set);
		}

		for (int k = i; k < str.length(); k++) {
			String p = str.substring(i, k + 1);
			if (set.contains(p)) {
				continue;
			}
			map.put(c, p);
			set.add(p);
			if (isMatch(str, k + 1, pat, j + 1, map, set)) {
				return true;
			}
			map.remove(c);
			set.remove(p);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(wordPatternMatch("abab","redbrueredbrue"));
	}
}
