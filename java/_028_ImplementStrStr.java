/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._028_ImplementStrStr
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 实现 strStr()
 * @author lilin
 * @date 2020-9-15 10:27
 */
public class _028_ImplementStrStr {
	/*
	实现strStr()函数。

	给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
	
	示例 1:
	
	输入: haystack = "hello", needle = "ll"
	输出: 2
	示例 2:
	
	输入: haystack = "aaaaa", needle = "bba"
	输出: -1
	说明:
	
	当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
	
	对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/implement-strstr
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}
		int max = haystack.length() - needle.length();
		for (int i = 0; i <= max; i++) {
			while (i <= max && haystack.charAt(i) != needle.charAt(0)) {
				i++;
			}
			if (i <= max) {
				int c = i;
				int j = 0;
				while (j < needle.length() && haystack.charAt(c++) == needle.charAt(j)) {
					j++;
				}
				if (j == needle.length()) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("mi", "a"));
	}
}
