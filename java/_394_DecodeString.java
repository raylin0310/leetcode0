/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._394_DecodeString
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * 字符串解码
 * @author lilin
 * @date 2021-1-6 10:23
 */
public class _394_DecodeString {
	/*
	给定一个经过编码的字符串，返回它解码后的字符串。

	编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
	
	你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
	
	此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。

	示例 1：
	
	输入：s = "3[a]2[bc]"
	输出："aaabcbc"
	示例 2：
	
	输入：s = "3[a2[c]]"
	输出："accaccacc"
	示例 3：
	
	输入：s = "2[abc]3[cd]ef"
	输出："abcabccdcdcdef"
	示例 4：
	
	输入：s = "abc3[cd]xyz"
	输出："abccdcdcdxyz"
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/decode-string
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		// res可以改为stringBuilder
		String res = "";
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = count * 10 + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			} else if (s.charAt(idx) == '[') {
				resStack.push(res);
				res = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int time = countStack.pop();
				for (int i = 0; i < time; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}


	public static void main(String[] args) {
		//System.out.println(decodeString("abc3[cd]xyz"));
		System.out.println(decodeString("2[3[ab]4[cd]]"));
	}
}
