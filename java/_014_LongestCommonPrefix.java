/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._014_LongestCommonPrefix
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最长公共前缀
 * @author lilin
 * @date 2020-9-15 11:06
 */
public class _014_LongestCommonPrefix {
	/*
	编写一个函数来查找字符串数组中的最长公共前缀。

	如果不存在公共前缀，返回空字符串""。
	
	示例1:
	
	输入: ["flower","flow","flight"]
	输出: "fl"
	示例2:
	
	输入: ["dog","racecar","car"]
	输出: ""
	解释: 输入不存在公共前缀。
	说明:
	
	所有输入只包含小写字母a-z。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/longest-common-prefix
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	 time:O(mn)其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
	 space:O(1)
	 */

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				/*
				当其中一个字符串已经到末尾了，即最短的一个字符串
				或者数组中某一个字符串不等于比较字符c的，就可以返回了
				 */
				if (strs[j].length() == i || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}

	public static void main(String[] args) {
		String[] strs = {"dog", "racecar", "car"};
		String[] strs2 = {"ab"};
		System.out.println(longestCommonPrefix(strs));
	}
}
