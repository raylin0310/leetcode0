/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._032_LongestValidParentheses
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * 最长有效括号
 * @author lilin
 * @date 2020-10-21 14:03
 */
public class _032_LongestValidParentheses {
	/*
	给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。

	示例1:
	
	输入: "(()"
	输出: 2
	解释: 最长有效括号子串为 "()"
	示例 2:
	
	输入: ")()())"
	输出: 4
	解释: 最长有效括号子串为 "()()"
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/longest-valid-parentheses
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		int start = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					start = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						res = Math.max(res, i - start);
					} else {
						res = Math.max(res, i - stack.peek());
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()()"));
	}
}
