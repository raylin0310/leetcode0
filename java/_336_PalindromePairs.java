/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._336_PalindromePairs
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 回文对
 * @author lilin
 * @date 2020-10-19 10:20
 */
public class _336_PalindromePairs {
	
	/*
	给定一组 互不相同 的单词， 找出所有不同的索引对(i, j)，使得列表中的两个单词，words[i] + words[j]，可拼接成回文串。

	示例 1：
	
	输入：["abcd","dcba","lls","s","sssll"]
	输出：[[0,1],[1,0],[3,2],[2,4]] 
	解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
	示例 2：
	
	输入：["bat","tab","cat"]
	输出：[[0,1],[1,0]] 
	解释：可拼接成的回文串为 ["battab","tabbat"]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/palindrome-pairs
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		time : O(n * k^2)
        space : O(n)
        n数组个数，k字符串平均长度
	 */

	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if (words == null || words.length < 2) {
			return res;
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String str2rvs = new StringBuilder(str2).reverse().toString();
					if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
						res.add(Arrays.asList(map.get(str2rvs), i));
					}
				}
				if (str2.length() != 0 && isPalindrome(str2)) {
					String str1rvs = new StringBuilder(str1).reverse().toString();
					if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
						res.add(Arrays.asList(i, map.get(str1rvs)));
					}
				}
			}
		}
		return res;
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

	}
}
