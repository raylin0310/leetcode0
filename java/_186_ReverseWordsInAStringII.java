/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._186_ReverseWordsInAStringII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 翻转字符串里的单词II
 * @author lilin
 * @date 2020-9-17 10:51
 */
public class _186_ReverseWordsInAStringII {
	
	/*
	给定一个字符串，逐个翻转字符串中的每个单词。

	示例：
	
	输入: ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
	输出: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
	注意：
	
	单词的定义是不包含空格的一系列字符
	输入字符串中不会包含前置或尾随的空格
	单词与单词之间永远是以单个空格隔开的
	进阶：使用 O(1) 额外空间复杂度的原地解法。
	
	思路：先反转每个单词，然后总体再翻转。
	 */

	public static void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		int r = 0;
		while (r < s.length){
			int l = r;
			while (r < s.length && s[r] != ' '){
				r++;
			}
			reverse(s,l,r-1);
			r++;
		}
	}

	private static void reverse(char[] s, int l, int r) {
		while (l < r) {
			char temp = s[l];
			s[l++] = s[r];
			s[r--] = temp;
		}
	}

	public static void main(String[] args) {
		char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		reverseWords(s);
		AU.print(s);
	}
}
