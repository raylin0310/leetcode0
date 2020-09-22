/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._013_RomanToInteger
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 罗马数字转整数
 * @author lilin
 * @date 2020-9-22 18:08
 */
public class _013_RomanToInteger {
	/*
	罗马数字包含以下七种字符:I，V，X，L，C，D和M。

	字符          数值
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
	
	通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
	同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
	
	I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
	X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
	C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
	给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
	
	
	
	示例1:
	
	输入:"III"
	输出: 3
	示例2:
	
	输入:"IV"
	输出: 4
	示例3:
	
	输入:"IX"
	输出: 9
	示例4:
	
	输入:"LVIII"
	输出: 58
	解释: L = 50, V= 5, III = 3.
	示例5:
	
	输入:"MCMXCIV"
	输出: 1994
	解释: M = 1000, CM = 900, XC = 90, IV = 4.
	
	
	提示：
	
	题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
	IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
	关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/roman-to-integer
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = toNumber(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (toNumber(s.charAt(i)) > toNumber(s.charAt(i - 1))) {
				//eq: (sum-pre)+(cur-pre)
				res += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
			} else {
				res += toNumber(s.charAt(i));
			}
		}
		return res;
	}


	public static int toNumber(char c) {
		int res = 0;
		switch (c) {
			case 'I' : return 1;
			case 'V' : return 5;
			case 'X' : return 10;
			case 'L' : return 50;
			case 'C' : return 100;
			case 'D' : return 500;
			case 'M' : return 1000;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("IV"));
	}
}
