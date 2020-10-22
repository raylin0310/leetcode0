/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._020_ValidParentheses
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 有效的括号
 * @author lilin
 * @date 2020-10-20 11:35
 */
public class _020_ValidParentheses {

	/*
	给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。

	有效字符串需满足：

	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。

	示例 1:

	输入: "()"
	输出: true
	示例2:

	输入: "()[]{}"
	输出: true
	示例3:

	输入: "(]"
	输出: false
	示例4:

	输入: "([)]"
	输出: false
	示例5:

	输入: "{[]}"
	输出: true

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/valid-parentheses
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	time:O(n)
	 */

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) {
					//可以提前结束遍历
					return false;
				}
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("([)]"));
	}
}
