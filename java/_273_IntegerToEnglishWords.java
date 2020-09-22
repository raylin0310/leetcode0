/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._273_IntegerToEnglishWords
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _273_IntegerToEnglishWords
 * @author lilin
 * @date 2020-9-22 18:42
 */
public class _273_IntegerToEnglishWords {
	/*
	将非负整数转换为其对应的英文表示。可以保证给定输入小于2^31 - 1 。

	示例 1:
	
	输入: 123
	输出: "One Hundred Twenty Three"
	示例 2:
	
	输入: 12345
	输出: "Twelve Thousand Three Hundred Forty Five"
	示例 3:
	
	输入: 1234567
	输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
	示例 4:
	
	输入: 1234567891
	输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/integer-to-english-words
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	题解：
	https://leetcode-cn.com/problems/integer-to-english-words/solution/zheng-shu-zhuan-huan-ying-wen-biao-shi-by-leetcode/
	 */


	static String[] less20={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static String[] tens={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static String[] thousands={"", "Thousand", "Million", "Billion"};

	public static String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		String res = "";
		int i = 0;
		while (num > 0) {
			if (num % 1000 != 0) {
				res = helper(num % 1000) + thousands[i] + " " + res;
			}
			num /= 1000;
			i++;
		}
		return res.trim();
	}
	public static String helper(int num) {
		if (num == 0) {
			return "";
		}
		if (num < 20) {
			return less20[num % 20] + " ";
		} else if (num < 100) {
			return tens[num / 10] + " " + helper(num % 10);
		} else {
			return less20[num / 100] + " Hundred " + helper(num % 100);
		}
	}

}
