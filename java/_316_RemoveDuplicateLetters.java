/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._316_RemoveDuplicateLetters
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 去除重复字母
 * @author lilin
 * @date 2020-9-21 16:26
 */
public class _316_RemoveDuplicateLetters {
	/*
	给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

	示例 1:
	
	输入: "bcabc"
	输出: "abc"
	示例 2:
	
	输入: "cbacdcbc"
	输出: "acdb"
	
	
	注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-duplicate-letters
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */


	//https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/
	public static String removeDuplicateLetters(String s) {
		Stack<Character> stk = new Stack<>();

		// 维护一个计数器记录字符串中字符的数量
		// 因为输入为 ASCII 字符，大小 256 够用了
		int[] count = new int[256];
		for (char c : s.toCharArray()) {
			count[c]++;
		}

		boolean[] inStack = new boolean[256];
		for (char c : s.toCharArray()) {
			// 每遍历过一个字符，都将对应的计数减一
			count[c]--;

			if (inStack[c]) {
				continue;
			}

			while (!stk.isEmpty() && stk.peek() > c) {
				// 若之后不存在栈顶元素了，则停止 pop
				if (count[stk.peek()] == 0) {
					break;
				}
				// 若之后还有，则可以 pop
				inStack[stk.pop()] = false;
			}
			stk.push(c);
			inStack[c] = true;
		}

		StringBuilder sb = new StringBuilder();
		while (!stk.empty()) {
			sb.append(stk.pop());
		}
		return sb.reverse().toString();
	}


	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
}
