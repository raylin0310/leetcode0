/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._772_BasicCalculatorIII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 计算第三
 * @author lilin
 * @date 2021-1-6 14:44
 */
public class _772_BasicCalculatorIII {
	/*
	既有加减乘除，又有括号
	https://github.com/grandyang/leetcode/issues/772
	 */

	public static int calculate(String s) {

		int res = 0;
		int p1 = 0;

		int p2 = 0;
		char op = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				p2 = p2 * 10 + (c - '0');
			} else if (c == '(') {
				int start = i;
				int cnt = 0;
				while (i < s.length()) {
					if (s.charAt(i) == '(') {
						cnt++;
					} else if (s.charAt(i) == ')') {
						cnt--;
					}
					if (cnt == 0) {
						break;
					}
					i++;
				}
				/*
					1+(3*4)+8
					start=2
					i=6
					sub(2,6)
					此时i=')'

					递归继续计算括号里面的
				 */
				p2 = calculate(s.substring(start + 1, i));
			}
			//当前是计算符时，计算前面的表达式
			if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
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
				// 当前是加减的话，前面就可以合并了，当前是乘除的话，p1还要参与下一次的计算
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
		System.out.println(calculate("2+(3*4+10/2)-6"));
	}
}
