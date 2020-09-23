/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._030_SubstringWithConcatenationOfAllWords
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 * @author lilin
 * @date 2020-9-23 15:30
 */
public class _030_SubstringWithConcatenationOfAllWords {
	/*
	给定一个字符串s和一些长度相同的单词words。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。

	注意子串要与words 中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。

	示例 1：
	
	输入：
	  s = "barfoothefoobarman",
	  words = ["foo","bar"]
	输出：[0,9]
	解释：
	从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
	输出的顺序不重要, [9,0] 也是有效答案。
	示例 2：
	
	输入：
	  s = "wordgoodgoodgoodbestword",
	  words = ["word","good","best","word"]
	输出：[]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		time : O(n ^ 2)
        space : O(n)
	 */

	public static List<Integer> findSubstring(String s, String[] words) {
		if (s == null || words == null || words.length == 0) {
			return new ArrayList<>();
		}

		List<Integer> res = new ArrayList<>();
		// 单词个数
		int n = words.length;
		// 每个单词的长度
		int m = words[0].length();

		//初始化words中每个单词出现的次数
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : words) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		for (int i = 0; i <= s.length() - n * m; i++) {
			HashMap<String, Integer> copy = new HashMap<>(map);
			// k 单词个数
			int k = n;
			// 开始指针
			int j = i;
			while (k > 0) {
				//截取m长度的字符
				String str = s.substring(j, j + m);
				if (!copy.containsKey(str) || copy.get(str) < 1) {
					//不在words中，或者出现的次数超出了
					break;
				}
				copy.put(str, copy.get(str) - 1);
				k--;
				j += m;
			}
			if (k == 0) {
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		System.out.println(findSubstring(s, words));
		//System.out.println(findSubstring2(s, words));
	}
}
