/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._266_PalindromePermutation
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashSet;

/**
 * _266_PalindromePermutation
 * @author lilin
 * @date 2020-9-27 11:03
 */
public class _266_PalindromePermutation {
	/*
	给定一个字符串，请确定该字符串的排列是否可能形成回文。

	Example 1:

	Input: "code"
	Output: false
	Example 2:

	Input: "aab"
	Output: true
	Example 3:

	Input: "carerac"
	Output: true
	Hint:

	Consider the palindromes of odd vs even length. What difference do you notice?
	考虑奇数长度与偶数长度的回文。您注意到什么区别？
	Count the frequency of each character.
	计算每个字符的频率。
	If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
	如果每个字符出现偶数次，则它一定是回文。出现奇数次的字符怎么样？
	 */

	//space : O(n)
	public static boolean canPermutePalindrome(String s) {
		HashSet<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		return set.size() <= 1;
	}

	//space : O(1)，这种不能判断中文
	public static boolean canPermutePalindrome2(String s) {
		char[] count = new char[256];
		int res = 0;
		for (char c : s.toCharArray()) {
			if (count[c] > 0) {
				count[c]--;
			} else {
				count[c]++;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				res++;
			}
		}
		return res <= 1;
	}

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("你好你"));
		//System.out.println(canPermutePalindrome2("你好你"));
	}

}
