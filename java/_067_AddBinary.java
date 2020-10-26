/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._067_AddBinary
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 二进制求和
 * @author lilin
 * @date 2020-10-23 10:31
 */
public class _067_AddBinary {
	/*
	给你两个二进制字符串，返回它们的和（用二进制表示）。

	输入为 非空 字符串且只包含数字1和0。

	示例1:
	
	输入: a = "11", b = "1"
	输出: "100"
	示例2:
	
	输入: a = "1010", b = "1011"
	输出: "10101"
	
	
	提示：
	
	每个字符串仅由字符 '0' 或 '1' 组成。
	1 <= a.length, b.length <= 10^4
	字符串如果不是 "0" ，就都不含前导零。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/add-binary
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int remainder = 0;
		while (i >= 0 || j >= 0) {
			int sum = remainder;
			if (i >= 0) {
				sum += a.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += b.charAt(j--) - '0';
			}
			sb.append(sum % 2);
			remainder = sum / 2;
		}
		if (remainder != 0) {
			sb.append(remainder);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {

	}
}
