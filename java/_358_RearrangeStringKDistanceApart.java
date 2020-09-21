/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._358_RearrangeStringKDistanceApart
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _358_RearrangeStringKDistanceApart
 * @author lilin
 * @date 2020-9-21 15:40
 */
public class _358_RearrangeStringKDistanceApart {
	/*
	Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

	重新排列字符串，以使相同字符之间的距离至少为k

	All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
	所有输入字符串均以小写字母给出,如果无法重新排列字符串，请返回空字符串“”
	Example 1:

	Input: s = "aabbcc", k = 3
	Output: "abcabc"
	Explanation: The same letters are at least distance 3 from each other.
	Example 2:

	Input: s = "aaabc", k = 3
	Output: ""
	Explanation: It is not possible to rearrange the string.
	Example 3:

	Input: s = "aaadbbcc", k = 2
	Output: "abacabcd"
	Explanation: The same letters are at least distance 2 from each other.
	 */

	/*
	time : O(nlogn) space : O(n)
	首先用一个哈希表记录每个字符出现的次数，然后将哈系表中的键值对推入优先级队列中，现在的关键点在于如何使相同字符直接的距离为k。
	可以想象，出现次数多的字符应该优先考虑放置，所以这个优先级队列是以字符出现次数作为比较函数的，
	队列顶是出现次数最多的字符。所以我们每次从队列中取出k个键值对，对其字符进行组合，然后将其次数减一
	 */

	public static String rearrangeString(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq =
				new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
		pq.addAll(map.entrySet());

		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		StringBuilder res = new StringBuilder();

		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> cur = pq.poll();
			res.append(cur.getKey());
			cur.setValue(cur.getValue() - 1);
			queue.offer(cur);
			if (queue.size() < k) {
				//这里采用了贪心算法，当等于k的时候，把queue里的元素继续加进优先队列中，
				//这里的意思是：出现次数越多的字符，就在刚好k距离的时候放
				//即【出现次数多的字符应该优先考虑放置】
				continue;
			}
			Map.Entry<Character, Integer> front = queue.poll();
			if (front.getValue() > 0) {
				pq.offer(front);
			}
		}
		return res.length() == s.length() ? res.toString() : "";
	}

	// time : O(n) space : O(n)
	public static String rearrangeString2(String s, int k) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int[] count = new int[26];
		int[] valid = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int nextLetter = findNext(count, valid, i);
			if (nextLetter == -1) {
				return "";
			}
			res.append((char)('a' + nextLetter));
			//表示nextLetter下标的字符的下标是i+k
			valid[nextLetter] = i + k;
			count[nextLetter]--;
		}
		return res.toString();
	}

	private static int findNext(int[] count, int[] valid, int index) {
		int max = 0, res = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max && valid[i] <= index) {
				res = i;
				max = count[i];
			}
		}
		return res;
	}

	//1比较好理解
	public static void main(String[] args) {
		System.out.println(rearrangeString("aabbcd", 3));
	}
}
