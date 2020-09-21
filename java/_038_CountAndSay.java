/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._038_CountAndSay
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 外观数列
 * @author lilin
 * @date 2020-9-21 10:57
 */
public class _038_CountAndSay {
	/*
	给定一个正整数 n（1 ≤n≤ 30），输出外观数列的第 n 项。

	注意：整数序列中的每一项将表示为一个字符串。
	
	「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
	
	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	第一项是数字 1
	
	描述前一项，这个数是 1 即 “一个 1 ”，记作 11
	
	描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
	
	描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
	
	描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221

	
	示例1:
	
	输入: 1
	输出: "1"
	解释：这是一个基本样例。
	示例 2:
	
	输入: 4
	输出: "1211"
	解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/count-and-say
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	//描述是count+char[start]的组合，从左到右遍历，计算字符相同的个数count

	public static String countAndSay(int n) {
		int i = 1;
		String res = "1";
		while (i < n) {
			StringBuilder sb = new StringBuilder();

			char c = res.charAt(0);
			int count = 0;
			for (int j = 0; j <= res.length(); j++) {
				if (j != res.length() && res.charAt(j) == c) {
					//计数
					count++;
				} else {
					//拼接
					sb.append(count);
					sb.append(c);
					if (j != res.length()) {
						count = 1;
						c = res.charAt(j);
					}
				}
			}
			res = sb.toString();
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
}
