/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._227_BasicCalculatorII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * 基本计算器 II
 * @author lilin
 * @date 2021-1-6 11:13
 */
public class _227_BasicCalculatorII {
	/*
	实现一个基本的计算器来计算一个简单的字符串表达式的值。

	字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
	
	示例1:
	
	输入: "3+2*2"
	输出: 7
	示例 2:
	
	输入: " 3/2 "
	输出: 1
	示例 3:
	
	输入: " 3+5 / 2 "
	输出: 5
	说明：
	
	你可以假设所给定的表达式都是有效的。
	请不要使用内置的库函数 eval。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/basic-calculator-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	//time : O(n)  space : O(n)
	/*
	  https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/
	 思路：当遇到符号时，处理前面的，因为乘除的优先性，我们可以先计算出来都放进栈里面，最后循环加起来即可
	 若1+2，当遇到+号时，处理前面的符号默认正，num=1，就push_stack(-2)
	 如1+2-3,当遇到-号时，处理前面的，符号是正，num=2，push_stack(+2)
	 如 1+2*3+4,当遇到第二个+号时，前面的符号是*，那么pop_stack()*num = (+2)*3 = 6，然后把6push_stack，最后栈里面的元素就是+1、+6、+4
	 */

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + (s.charAt(i) - '0');
			}
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}
		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}

	// time : O(n)  space : O(1)
	public static int calculate2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		int p1 = 0;

		int p2 = 0;
		char op = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				p2 = p2 * 10 + (c - '0');
			}
			if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
				//遇到下一个符号，计算前面的数字和符号
				switch (op) {
					case '+':
						p1 += p2;
						break;
					case '-':
						p1 -= p2;
						break;
					case '*':
						p1 *= p2;
						break;
					case '/':
						p1 /= p2;
						break;
				}
				// 当前符号是+、-的话，前面就可以合并了，如果当前是*、/的话，说明cur还要继续参与计算
				if (c == '+' || c == '-' || i == s.length() - 1) {
					res += p1;
					p1 = 0;
				}
				op = c;
				p2 = 0;
			}
		}
		return res;
	}


	public static void main(String[] args) {
		System.out.println(calculate2("3+4*5"));
	}
}
