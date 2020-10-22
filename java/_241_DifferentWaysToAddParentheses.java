/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._241_DifferentWaysToAddParentheses
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 为运算表达式设计优先级
 * @author lilin
 * @date 2020-10-21 15:18
 */
public class _241_DifferentWaysToAddParentheses {
	/*
	给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +,-以及*。

	示例1:
	
	输入: "2-1-1"
	输出: [0, 2]
	解释: 
	((2-1)-1) = 0 
	(2-(1-1)) = 2
	示例2:
	
	输入: "2*3-4*5"
	输出: [-34, -14, -10, -10, 10]
	解释: 
	(2*(3-(4*5))) = -34 
	((2*3)-(4*5)) = -14 
	((2*(3-4))*5) = -10 
	(2*((3-4)*5)) = -10 
	(((2*3)-4)*5) = 10
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
	 */

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '-' || c == '+' || c == '*') {
				String a = input.substring(0, i);
				String b = input.substring(i + 1);
				List<Integer> al = diffWaysToCompute(a);
				List<Integer> bl = diffWaysToCompute(b);
				for (int x : al) {
					for (int y : bl) {
						if (c == '-') {
							res.add(x - y);
						} else if (c == '+') {
							res.add(x + y);
						} else if (c == '*') {
							res.add(x * y);
						}
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("3-2-1"));
	}
}
