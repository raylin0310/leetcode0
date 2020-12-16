/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._017_LetterCombinationsOfAPhoneNumber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合
 * @author lilin
 * @date 2020-12-16 10:43
 */
public class _017_LetterCombinationsOfAPhoneNumber {
	/*
	给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。

	给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
	示例:
	
	输入："23"
	输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/**
	 * time : O(3^n)
	 * space : O(n)
	 */

	private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		helper(res, digits, "", 0);
		return res;
	}

	public void helper(List<String> res, String digits, String s, int index) {
		if (index == digits.length()) {
			res.add(s);
			return;
		}
		String letters = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			helper(res, digits, s + letters.charAt(i), index + 1);
		}
	}

	public List<String> letterCombinations2(String digits) {
		LinkedList<String> res = new LinkedList<>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			int num = digits.charAt(i) - '0';
			while (res.peek().length() == i) {
				String t = res.remove();
				for (char s : mapping[num].toCharArray()) {
					res.add(t + s);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		_017_LetterCombinationsOfAPhoneNumber test = new _017_LetterCombinationsOfAPhoneNumber();
		System.out.println(test.letterCombinations2("2345"));
	}
}
