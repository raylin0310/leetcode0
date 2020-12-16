/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._093_RestoreIPAddresses
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _093_RestoreIPAddresses
 * @author lilin
 * @date 2020-12-16 11:40
 */
public class _093_RestoreIPAddresses {
	/*
	给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

	有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
	
	例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
	示例 1：
	
	输入：s = "25525511135"
	输出：["255.255.11.135","255.255.111.35"]
	示例 2：
	
	输入：s = "0000"
	输出：["0.0.0.0"]
	示例 3：
	
	输入：s = "1111"
	输出：["1.1.1.1"]
	示例 4：
	
	输入：s = "010010"
	输出：["0.10.0.10","0.100.1.0"]
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/restore-ip-addresses
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}

	public boolean isValid(String s) {
		if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
			return false;
		}
		return true;
	}


	public static List<String> restoreIpAddresses2(String s) {
		List<String> res = new ArrayList<>();
		helper(res, s, 0, "", 0);
		return res;
	}

	public static void helper(List<String> res, String s, int index, String ret, int count) {
		if (count > 4) {
			return;
		}
		if (count == 4 && index == s.length()) {
			res.add(ret);
			return;
		}
		for (int i = 1; i < 4; i++) {
			if (index + i > s.length()) break;
			String temp = s.substring(index, index + i);
			if ((temp.startsWith("0") && temp.length() > 1) || (i == 3 && Integer.parseInt(temp) >= 256)) continue;
			helper(res, s, index + i, ret + temp + (count == 3 ? "" : "."), count + 1);
		}
	}
}
