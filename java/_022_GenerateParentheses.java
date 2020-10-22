/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._022_GenerateParentheses
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *  括号生成
 * @author lilin
 * @date 2020-10-21 11:17
 */
public class _022_GenerateParentheses {
	/*
	数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
	示例：
	输入：n = 3
	输出：[
	       "((()))",
	       "(()())",
	       "(())()",
	       "()(())",
	       "()()()"
	     ]
				()
	     ()()
	     (())
	     (())
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/generate-parentheses
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
	回溯算法
	深度优先遍历
	 */

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		helper(res, "", n, n);
		return res;
	}

	public static void helper(List<String> res, String s, int left, int right) {
		if (left > right) {
			return;
		}
		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}
		if (left > 0) {
			helper(res, s + "(", left - 1, right);
		}
		if (right > 0) {
			helper(res, s + ")", left, right - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
