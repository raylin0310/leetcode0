/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._065_ValidNumber
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 有效数字
 * @author lilin
 * @date 2020-9-23 13:59
 */
public class _065_ValidNumber {
	/*
	验证给定的字符串是否可以解释为十进制数字。

	例如:
	
	"0"=>true
	" 0.1 "=>true
	"abc"=>false
	"1 a"=>false
	"2e10"=>true
	" -90e3 "=>true
	" 1e"=>false
	"e3"=>false
	" 6e-1"=>true
	" 99e2.5"=>false
	"53.5e93"=>true
	" --6 "=>false
	"-+3"=>false
	"95a54e53"=>false
	
	说明:我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
	
	数字 0-9
	指数 - "e"
	正/负号 - "+"/"-"
	小数点 - "."
	当然，在输入中，这些字符的上下文也很重要。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/valid-number
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static boolean isNumber(String s) {
		s = s.trim();
		boolean numberSeen = false;
		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numberAfterE = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				numberSeen = true;
				numberAfterE = true;
			} else if (s.charAt(i) == '.') {
				if (eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			} else if (s.charAt(i) == 'e') {
				if (eSeen || !numberSeen) {
					return false;
				}
				eSeen = true;
				numberAfterE = false;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
		}
		return numberSeen && numberAfterE;
	}

	public static void main(String[] args) {
		System.out.println(isNumber(".9"));
	}
}
