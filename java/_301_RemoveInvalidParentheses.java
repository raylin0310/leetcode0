/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._301_RemoveInvalidParentheses
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 删除无效的括号 (不会)
 * @author lilin
 * @date 2020-10-21 16:49
 */
public class _301_RemoveInvalidParentheses {

	/*
	删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

	说明: 输入可能包含了除(和)以外的字符。

	示例 1:

	输入: "()())()"
	输出: ["()()()", "(())()"]
	示例 2:

	输入: "(a)())()"
	输出: ["(a)()()", "(a())()"]
	示例 3:

	输入: ")("
	输出: [""]

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
	 */

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		helper(res, s, 0, 0, new char[]{'(', ')'});
		return res;
	}
	public void helper(List<String> res, String s, int last_i, int last_j, char[] pair) {
		for (int count = 0, i = last_i; i < s.length(); i++) {
			if (s.charAt(i) == pair[0]) count++;
			if (s.charAt(i) == pair[1]) count--;
			if (count >= 0) continue;
			/*
			如果到达此处，则表示计数<0。显然。
			这意味着从last_i到count_i（包括） ,还有一个额外的 pari[1]。
			例如: 如果sub_str =（）），那么我们可以删除中间的）
			例如: 如果sub_str =（）（）），我们可以删除sub_str [1]，它变成（（））,或者我们可以删除sub_str [3]，它变成（）（
			在第二个示例中，对于最后两个）），我们要确保仅考虑删除第一个），而不是第二个。这样，我们可以避免结果重复。
			为了达到这个目的，我们需要这个条件 s [j] ==pair[1] and s[j-1]！= s[j]

			但是，s[last_i] ==pari[1]，该怎么办，然后j-1超出范围（last_i，i +1）
			 */
			for (int j = last_j; j <= i; j++) {
				if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
					helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
				}
			}
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (pair[0] == '(') {
			helper(res, reversed, 0, 0, new char[]{')', '('});
		} else {
			res.add(reversed);
		}
	}

	public static void main(String[] args) {

	}
}
