/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._267_PalindromePermutationII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * _267_PalindromePermutationII
 * TODO
 * @author lilin
 * @date 2020-10-20 11:11
 */
public class _267_PalindromePermutationII {

	/*

	给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。

	如不能形成任何回文排列时，则返回一个空列表。
	 */

	/*
	这道题是之前那道 Palindrome Permutation 的拓展，那道题只是让判断存不存在回文全排列，而这题让返回所有的回文全排列，
	此题给了我们充分的提示：如果回文全排列存在，只需要生成前半段字符串即可，后面的直接根据前半段得到。那么再进一步思考，
	由于回文字符串有奇偶两种情况，偶数回文串例如 abba，可以平均分成前后半段，而奇数回文串例如 abcba，需要分成前中后三段，
	需要注意的是中间部分只能是一个字符，可以分析得出，如果一个字符串的回文字符串要存在，那么奇数个的字符只能有0个或1个，
	其余的必须是偶数个，所以可以用哈希表来记录所有字符的出现个数，然后找出出现奇数次数的字符加入 mid 中，
	如果有两个或两个以上的奇数个数的字符，则返回空集，对于每个字符，不管其奇偶，都将其个数除以2的个数的字符加入t中，
	这样做的原因是如果是偶数个，将其一般加入t中，如果是奇数，如果有1个，除以2是0，
	不会有字符加入t，如果是3个，除以2是1，取一个加入t。等获得了t之后，t是就是前半段字符，对其做全排列，每得到一个全排列，
	加上 mid 和该全排列的逆序列就是一种所求的回文字符串，这样就可以得到所有的回文全排列了。在全排序的子函数中有一点需要注意的是，
	如果直接用数组来保存结果时，并且t中如果有重复字符的话可能会出现重复项，比如 t = "baa" 的话，那么最终生成的结果会有重复项，
	不信可以自己尝试一下。这里简单的说明一下，当 start=0，i=1 时，交换后得到 aba，在之后当 start=1，i=2 时，交换后可以得到 aab。
	但是在之后回到第一层当baa后，当 start=0，i=2 时，交换后又得到了 aab，重复就产生了。那么其实最简单当去重复的方法就是将结果 res
	定义成 HashSet，利用其去重复的特性，可以保证得到的是没有重复的，参见代码如下：
	 */


	public static List<String> generatePalindromes(String s) {
		int odd = 0;
		String mid = "";
		List<String> res = new ArrayList<>();
		List<Character> list = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			odd += map.get(c) % 2 != 0 ? 1 : -1;
		}
		if (odd > 1) {
			return res;
		}

		for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			if (val % 2 != 0) {
				mid += key;
			}
			for (int i = 0; i < val / 2; i++) {
				list.add(key);
			}
		}
		helper(list, mid, new boolean[list.size()], new StringBuilder(), res);
		return res;
	}

	private static void helper(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
		if (sb.length() == list.size()) {
			res.add(sb.toString() + mid + sb.reverse().toString());
			sb.reverse();
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i).equals(list.get(i - 1)) && !used[i - 1]) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				sb.append(list.get(i));
				helper(list, mid, used, sb, res);
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(generatePalindromes("abba"));
	}
}
