/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._139_WordBreak
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * @author lilin
 * @date 2020-12-21 10:15
 */
public class _139_WordBreak {
	/*
	给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。

	说明：

	拆分时可以重复使用字典中的单词。
	你可以假设字典中没有重复的单词。
	示例 1：

	输入: s = "leetcode", wordDict = ["leet", "code"]
	输出: true
	解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
	示例 2：

	输入: s = "applepenapple", wordDict = ["apple", "pen"]
	输出: true
	解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
	    注意你可以重复使用字典中的单词。
	示例 3：

	输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	输出: false

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/word-break
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	官方题解：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
	dp[i] 表示0到i的子串可以满足题目要求
	 time : O(n^2);
     space : O(n);
	 */

	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		// 计算min是为了提前结束，假如min=5，那么剩余字符子串的长度小于5时，就没必要再去循环了
		int min = Integer.MAX_VALUE;
		for (String str : wordDict) {
			min = Math.min(min, str.length());
		}
		for (int i = 1; i <= n; i++) {
			// n 10 min 3  7 8 9 j<=7 (10-3)
			//tip 这里j从i-1到0遍历会有性能提升
			for (int j = 0; j < i && j <= i - min; j++) {
				// dp[j] 表示0到j这一段在dict中，后面contains表示j到i这一段在dict中
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	// 回溯思想，这里其实就是暴力破解 超出时间限制
	public static boolean wordBreak2(String s, List<String> wordDict) {
		return dfs(s, wordDict, 0);
	}

	public static boolean dfs(String s, List<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			if (wordDict.contains(s.substring(start, i))) {
				boolean result = dfs(s, wordDict, i);
				if (result) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "applepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen");
		System.out.println(wordBreak(s, wordDict));
	}
}
