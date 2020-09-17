/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._345_ReverseVowelsOfAString
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 *  反转字符串中的元音字母
 * @author lilin
 * @date 2020-9-17 11:01
 */
public class _345_ReverseVowelsOfAString {
	/*
	编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

	示例 1：
	
	输入："hello"
	输出："holle"
	示例 2：
	
	输入："leetcode"
	输出："leotcede"

	提示：
	
	元音字母不包含字母 "y" 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String vowels = "aeiouAEIOU";
		char[] array = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start < end && vowels.indexOf(array[start]) == -1) {
				start++;
			}
			while (start < end && vowels.indexOf(array[end]) == -1) {
				end--;
			}
			char temp = array[start];
			array[start++] = array[end];
			array[end--] = temp;
		}
		return String.valueOf(array);
	}

	public static void main(String[] args) {

	}
}
