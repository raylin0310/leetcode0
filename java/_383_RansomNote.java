/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._383_RansomNote
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 赎金信
 * @author lilin
 * @date 2020-9-17 10:20
 */
public class _383_RansomNote {
	/*
	给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

	(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
	
	注意：
	
	你可以假设两个字符串均只含有小写字母。
	
	canConstruct("a", "b") -> false
	canConstruct("aa", "ab") -> false
	canConstruct("aa", "aab") -> true
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/ransom-note
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < magazine.length(); i++) {
			Integer n = map.getOrDefault(magazine.charAt(i), 0);
			n++;
			map.put(magazine.charAt(i), n);
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			Integer d = map.get(ransomNote.charAt(i));
			if (d == null || d == 0) {
				return false;
			}
			d--;
			map.put(ransomNote.charAt(i), d);
		}
		return true;
	}

	public boolean canConstruct2(String ransomNote, String magazine) {
		int[] count = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			count[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (--count[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(canConstruct("aa","ab"));
	}
}
