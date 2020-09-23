/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._246_StrobogrammaticNumber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;

/**
 * 中心对称数
 * @author lilin
 * @date 2020-9-23 10:11
 */
public class _246_StrobogrammaticNumber {
	/*
	中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。

	请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。

	例 1:
	输入:  "69"
	输出: true

	示例 2:
	输入:  "88"
	输出: true

	示例 3:
	输入:  "962"
	输出: false
	 */

	public static boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('0', '0');
		map.put('8', '8');
		map.put('1', '1');
		int left = 0, right = num.length() - 1;
		while (left<=right){
			//相等也要走循环，是因为奇数个时，中间位的字符也要满足条件，满足条件的只有018
			if (!map.containsKey(num.charAt(left))){
				return false;
			}
			if (map.get(num.charAt(left)) != num.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
	}
}
