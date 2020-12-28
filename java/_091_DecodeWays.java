/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._091_DecodeWays
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 解码方法
 * @author lilin
 * @date 2020-12-28 14:11
 */
public class _091_DecodeWays {
	/*
	一条包含字母A-Z 的消息通过以下方式进行了编码：

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	给定一个只包含数字的非空字符串，请计算解码方法的总数。
	
	题目数据保证答案肯定是一个 32 位的整数。

	示例 1：
	
	输入：s = "12"
	输出：2
	解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
	示例 2：
	
	输入：s = "226"
	输出：3
	解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
	示例 3：
	
	输入：s = "0"
	输出：0
	示例 4：
	
	输入：s = "1"
	输出：1
	示例 5：
	
	输入：s = "2"
	输出：1

	提示：
	
	1 <= s.length <= 100
	s 只包含数字，并且可能包含前导零。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/decode-ways
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for (int i = 2; i <= len; i++) {
			int first = Integer.parseInt(s.substring(i - 1, i));
			int second = Integer.parseInt(s.substring(i - 2, i));
			if (first >= 1 && first <= 9) {
				dp[i] += dp[i - 1];
			}
			if (second >= 10 && second <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[len];
	}


	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
	}
}
