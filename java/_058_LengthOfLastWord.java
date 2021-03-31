/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._058LengthOfLastWord
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 最后一个单词的长度
 * @author lilin
 * @date 2020-9-15 11:23
 */
public class _058_LengthOfLastWord {
	/*
	给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

	如果不存在最后一个单词，请返回 0。
	
	说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

	
	示例:
	
	输入: "Hello World"
	输出: 5
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/length-of-last-word
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int lengthOfLastWord(String s) {
		int end = s.length() - 1;
		while(end >= 0 && s.charAt(end) == ' ') {
			end--;
		}
		if(end < 0) {
			return 0;
		}
		int start = end;
		while(start >= 0 && s.charAt(start) != ' ') {
			start--;
		}
		return end - start;

	}

	public static int lengthOfLastWord2(String s) {
		int end = s.length() - 1;
		while(end >= 0 && s.charAt(end) == ' ') {
			end--;
		}
		if(end < 0) {
			return 0;
		}
		int res = 0;
		while(end >= 0 && s.charAt(end) != ' ') {
			end--;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world  "));
	}
}
