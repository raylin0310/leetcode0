/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._402_RemoveKDigits
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * _402_RemoveKDigits
 * @author lilin
 * @date 2020-9-22 10:06
 */
public class _402_RemoveKDigits {
	/*
	给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。

	注意:
	
	num 的长度小于 10002 且≥ k。
	num 不会包含任何前导零。
	示例 1 :
	
	输入: num = "1432219", k = 3
	输出: "1219"
	解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
	示例 2 :
	
	输入: num = "10200", k = 1
	输出: "200"
	解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
	示例 3 :
	
	输入: num = "10", k = 2
	输出: "0"
	解释: 从原数字移除所有的数字，剩余为空就是0。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-k-digits
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

		time : O(n)
        space : O(n)
	 */

	public static String removeKdigits(String num, int k) {
		if (num.length() < k) {
			return num;
		}
		if (k == num.length()) {
			return "0";
		}
		Stack<Character> stack = new Stack<>();
		//最后字符总个数
		int n = num.length() - k;
		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);
			//剩下的字符个数+stack.size > n时才pop
			while (!stack.isEmpty() && stack.peek() > c && stack.size() + num.length() - i > n) {
				stack.pop();
			}
			stack.push(c);
		}
		while (stack.size() > n) {
			stack.pop();
		}
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		builder.reverse();
		int res = 0;
		while (res < builder.length() && builder.charAt(res) == '0') {
			res++;
		}
		return res == builder.length() ? "0" : builder.substring(res);
	}

	public static String removeKdigits2(String num, int k) {
		if (k == num.length()) {
			return "0";
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < num.length(); i++) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				//这里直接k--是因为紧挨着前面的字符，即当前字符要小
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();

		int res = 0;
		while (res < sb.length() && sb.charAt(res) == '0') {
			res++;
		}
		return res == sb.length() ? "0" : sb.substring(res);
	}

	public static void main(String[] args) {
		//System.out.println(removeKdigits("1432219",3));//1219
		//System.out.println(removeKdigits("10200",1));//200
		//System.out.println(removeKdigits("101",3));//0
		//System.out.println(removeKdigits2("154398765",3));//0
		System.out.println(removeKdigits2("15432321111111", 1));//0
	}
}
