/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._12_IntegerToRoman
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _12_IntegerToRoman
 * @author lilin
 * @date 2020-9-22 18:15
 */
public class _012_IntegerToRoman {
	/*
	https://leetcode-cn.com/problems/integer-to-roman/
	 */

	public static String intToRoman(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = intToRoman(140);
		System.out.println(s);
		System.out.println(_013_RomanToInteger.romanToInt(s));
	}
}


