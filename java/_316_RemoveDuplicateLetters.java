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

	https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/
	 */

	public static String removeDuplicateLetters(String s) {
		// find pos - the index of the leftmost letter in our solution
		// we create a counter and end the iteration once the suffix doesn't have each unique character
		// pos will be the index of the smallest character we encounter before the iteration ends
		int[] cnt = new int[26];
		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) {
				pos = i;
			}
			if (--cnt[s.charAt(i) - 'a'] == 0) {
				break;
			}
		}
		// our answer is the leftmost letter plus the recursive call on the remainder of the string
		// note that we have to get rid of further occurrences of s[pos] to ensure that there are no duplicates
		return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));

	}

	public static String removeDuplicateLetters2(String s) {

		Stack<Character> stack = new Stack<>();

		// this lets us keep track of what's in our solution in O(1) time
		//用来判断是否添加到stack中，这里用个数组其实也可以
		HashSet<Character> seen = new HashSet<>();

		// this will let us know if there are any more instances of s[i] left in s
		// 这将让我们知道s中是否还有s [i]的实例
		HashMap<Character, Integer> last_occurrence = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			last_occurrence.put(s.charAt(i), i);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// we can only try to add c if it's not already in our solution
			// this is to maintain only one of each character
			if (!seen.contains(c)) {
				// if the last letter in our solution:
				//     1. exists
				//     2. is greater than c so removing it will make the string smaller
				//     3. it's not the last occurrence
				// we remove it from the solution to keep the solution optimal
				while (!stack.isEmpty() && stack.peek() > c && last_occurrence.get(stack.peek()) > i) {
					seen.remove(stack.pop());
				}
				seen.add(c);
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder(stack.size());
		for (Character c : stack) {
			sb.append(c.charValue());
		}
		return sb.toString();
	}

	//https://leetcode-cn.com/problems/remove-duplicate-letters/solution/you-qian-ru-shen-dan-diao-zhan-si-lu-qu-chu-zhong-/
	public static String removeDuplicateLetters3(String s) {
		Stack<Character> stk = new Stack<>();

		// 维护一个计数器记录字符串中字符的数量
		// 因为输入为 ASCII 字符，大小 256 够用了
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}

		boolean[] inStack = new boolean[256];
		for (char c : s.toCharArray()) {
			// 每遍历过一个字符，都将对应的计数减一
			count[c - 'a']--;

			if (inStack[c]) {
				continue;
			}

			while (!stk.isEmpty() && stk.peek() > c) {
				// 若之后不存在栈顶元素了，则停止 pop
				if (count[stk.peek() - 'a'] == 0) {
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

	//自己写的
	public static String removeDuplicateLetters4(String s) {
		Stack<Character> stack = new Stack<>();

		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		boolean[] inStack = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			cnt[c-'a']--;
			if (inStack[c -'a']){
				//如果已经在stack中了，则不添加，去重作用，用set也可以
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > c && cnt[stack.peek()-'a'] > 0){
				Character p = stack.pop();
				inStack[p-'a']=false;
			}
			stack.push(c);
			inStack[c-'a']=true;
		}
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()){
			builder.append(stack.pop());
		}
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters3("bcabc"));
		System.out.println(removeDuplicateLetters4("bcabc"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
		System.out.println(removeDuplicateLetters3("cbacdcbc"));
		System.out.println(removeDuplicateLetters4("cbacdcbc"));
	}
}
