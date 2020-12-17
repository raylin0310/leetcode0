/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._282_ExpressionAddOperators
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给表达式添加运算符
 * @author lilin
 * @date 2020-12-16 19:48
 */
public class _282_ExpressionAddOperators {
	/*
	给定一个仅包含数字0-9的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、-或*，返回所有能够得到目标值的表达式。

	示例 1:
	
	输入: num = "123", target = 6
	输出: ["1+2+3", "1*2*3"] 
	示例2:
	
	输入: num = "232", target = 8
	输出: ["2*3+2", "2+3*2"]
	示例 3:
	
	输入: num = "105", target = 5
	输出: ["1*0+5","10-5"]
	示例4:
	
	输入: num = "00", target = 0
	输出: ["0+0", "0-0", "0*0"]
	示例 5:
	
	输入: num = "3456237490", target = 9191
	输出: []
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/expression-add-operators
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	参考英文题解第一个
	 */

	public static List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		if (num == null || num.length() == 0) {
			return res;
		}
		dfs(res, "", num, target, 0, 0, 0);
		return res;
	}


	private static void dfs(List<String> res, String path, String num, int target, int pos, long val, long pre) {
		if (pos == num.length()) {
			if (target == val) {
				res.add(path);
			}
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') {
				// 去除开头为0的数字
				break;
			}
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				dfs(res, path + cur, num, target, i + 1, cur, cur);
			} else {
				dfs(res, path + "+" + cur, num, target, i + 1, val + cur, cur);
				dfs(res, path + "-" + cur, num, target, i + 1, val - cur, -cur);
				// 1 + 2 * 3   val=3 cur=3 pre=2 : (val-pre) + pre * cur
				dfs(res, path + "*" + cur, num, target, i + 1, val - pre + pre * cur, pre * cur);
			}
		}
	}

	/*
		path 用stringBuilder更高效，但是要注意回溯时恢复状态
	 */

	private static void dfs2(List<String> res, StringBuilder path, String num, int target, int pos, long val, long pre) {
		if (pos == num.length()) {
			if (target == val) {
				res.add(path.toString());
				return;
			}
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') {
				// 去除开头为0的数字
				break;
			}
			long cur = Long.parseLong(num.substring(pos, i + 1));
			int len = path.length();
			if (pos == 0) {
				dfs2(res, path.append(cur), num, target, i + 1, cur, cur);
			} else {
				dfs2(res, path.append("+").append(cur), num, target, i + 1, val + cur, cur);
				path.setLength(len);
				dfs2(res, path.append("-").append(cur), num, target, i + 1, val - cur, -cur);
				path.setLength(len);
				// 1 + 2 * 3   val=3 cur=3 pre=2 : (val-pre) + pre * cur
				dfs2(res, path.append("*").append(cur), num, target, i + 1, val - pre + pre * cur, pre * cur);
			}
		}
	}


	public static void main(String[] args) {
		//System.out.println(addOperators("1022", 6));
		System.out.println(addOperators("105", 5));
	}
}
