/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._076_MinimumWindowSubstring
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最小覆盖子串
 * @author lilin
 * @date 2020-9-23 14:05
 */
public class _076_MinimumWindowSubstring {
	/*
	给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。

	示例：
	
	输入：S = "ADOBECODEBANC", T = "ABC"
	输出："BANC"

	提示：
	
	如果 S 中不存这样的子串，则返回空字符串 ""。
	如果 S 中存在这样的子串，我们保证它是唯一的答案。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/minimum-window-substring
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	思路：滑动窗口

	 */

	public static String minWindow2(String s, String t) {
		if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
			return "";
		}
		//用来统计t中每个字符出现次数
		int[] needs = new int[128];
		//用来统计滑动窗口中每个字符出现次数
		int[] window = new int[128];

		for (int i = 0; i < t.length(); i++) {
			needs[t.charAt(i)]++;
		}
		//最后字符串截取的开始指针
		int from = 0;
		//窗口最左侧的指针
		int left = 0;
		int total = 0;
		//包含全部t字符的最小长度
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			window[c]++;
			if (needs[c] > 0 && window[c] <= needs[c]) {
				total++;
			}
			while (total == t.length()) {
				if (i - left + 1 < min) {
					min = i - left + 1;
					from = left;
				}
				char cl = s.charAt(left);
				window[cl]--;
				if (window[cl] < needs[cl]) {
					total--;
				}
				left++;
			}
		}
		return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
	}

	//用一个计数数组，窗口右侧指针移动时，计数数组字符数量减少，左侧指针移动时，数量增加(有点像音符跳动)
	public static String minWindow3(String s, String t) {
		if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
			return "";
		}
		//初始化t中的字符数量
		int[] cnt = new int[128];
		for (char c : t.toCharArray()) {
			cnt[c]++;
		}
		int from = 0;
		int left = 0;
		int total = t.length();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (cnt[s.charAt(i)]-- > 0) {
				//说明命中t中字符
				total--;
			}
			while (total == 0) {
				//计算偏移量
				if (i - left + 1 < min) {
					min = i - left + 1;
					from = left;
				}
				//开始移动窗口左侧指针
				char cl = s.charAt(left);
				cnt[cl]++;
				if (cnt[cl] > 0) {
					total++;
				}
				left++;
			}
		}
		return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
	}

	public static void main(String[] args) {
		System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow3("ADOBECODEBANC", "ABC"));
	}
}
