/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._224_BasicCalculator
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * 基本计算器
 * @author lilin
 * @date 2021-1-6 10:59
 */
public class _224_BasicCalculator {
	/*
	实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。

	示例 1：
	
	输入：s = "1 + 1"
	输出：2
	示例 2：
	
	输入：s = " 2-1 + 2 "
	输出：3
	示例 3：
	
	输入：s = "(1+(4+5+2)-3)+(6+8)"
	输出：23
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/basic-calculator
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int sign = 1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int num = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					num = num * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				res += num * sign;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				res = res * stack.pop() + stack.pop();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}
}

