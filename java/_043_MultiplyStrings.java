/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._043_MultiplyStrings
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 字符串相乘
 * @author lilin
 * @date 2020-10-23 13:44
 */
public class _043_MultiplyStrings {
	/*
	给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。

	示例 1:
	
	输入: num1 = "2", num2 = "3"
	输出: "6"
	示例2:
	
	输入: num1 = "123", num2 = "456"
	输出: "56088"
	说明：
	
	num1和num2的长度小于110。
	num1 和num2 只包含数字0-9。
	num1 和num2均不以零开头，除非是数字 0 本身。
	不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/multiply-strings
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
		 */

	public static String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return "0";
		}
		int[] digits = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				// p1 表示进位数，p2表示余数
				int p1 = i + j, p2 = i + j + 1;
				//下一次的和，要加上上一次算出来的进位，也就是当前坐标的前一个即（i+j）+1,即这里的p2(i+j+1)是上一次的p1(i+j)
				int sum = product + digits[p2];
				digits[p1] += sum / 10;
				digits[p2] = sum % 10;
			}
		}
		StringBuilder res = new StringBuilder();
		for (int digit : digits) {
			//去掉首位0
			if (!(digit == 0 && res.length() == 0)) {
				res.append(digit);
			}
		}
		return res.length() == 0 ? "0" : res.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("1234","567"));
	}
}
