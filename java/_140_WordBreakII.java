/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._140_WordBreakII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 单词拆分 II
 * @author lilin
 * @date 2020-12-17 10:09
 */
public class _140_WordBreakII {
	/*
	给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
	说明：
	
	分隔时可以重复使用字典中的单词。
	你可以假设字典中没有重复的单词。
	示例 1：
	
	输入:
	s = "catsanddog"
	wordDict = ["cat", "cats", "and", "sand", "dog"]
	输出:
	[
	 "cats and dog",
	 "cat sand dog"
	]
	示例 2：
	
	输入:
	s = "pineapplepenapple"
	wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
	输出:
	[
	 "pine apple pen apple",
	 "pineapple pen apple",
	 "pine applepen apple"
	]
	解释: 注意你可以重复使用字典中的单词。
	示例3：
	
	输入:
	s = "catsandog"
	wordDict = ["cats", "dog", "sand", "and", "cat"]
	输出:
	[]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/word-break-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 记忆化搜索
	 */

	HashMap<Integer, List<String>> map = new HashMap<>();

	// DFS
	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, wordDict, 0);
	}

	public List<String> dfs(String s, List<String> wordDict, int start) {
		if (map.containsKey(start)) {
			return map.get(start);
		}
		List<String> res = new ArrayList<>();
		if (start == s.length()) {
			res.add("");
			return res;
		}
		for (int end = start + 1; end <= s.length(); end++) {
			String word = s.substring(start, end);
			if (wordDict.contains(word)) {
				List<String> list = dfs(s, wordDict, end);
				for (String temp : list) {
					res.add(word + ("".equals(temp) ? "" : " ") + temp);
				}
			}
		}
		map.put(start, res);
		return res;
	}

	public static void main(String[] args) {
		_140_WordBreakII test = new _140_WordBreakII();
		String s = "pineapplepenapple";
		String[] wordDict = {"apple", "pen", "applepen", "pine", "pineapple"};
		System.out.println(test.wordBreak(s, Arrays.asList(wordDict)));
	}
}

