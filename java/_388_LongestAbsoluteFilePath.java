/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._388_LongestAbsoluteFilePath
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Stack;

/**
 * 文件的最长绝对路径
 * @author lilin
 * @date 2021-1-6 10:09
 */
public class _388_LongestAbsoluteFilePath {
	/*
	题目见官解
	https://leetcode-cn.com/problems/longest-absolute-file-path/description/
	 */


	public static int lengthLongestPath(String input) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int res = 0;
		String[] arr = input.split("\n");
		for (String s : arr) {
			int level = s.lastIndexOf("\t") + 1;
			while (level + 1 < stack.size()) {
				stack.pop();
			}
			int len = stack.peek() + s.length() - level + 1;
			stack.push(len);
			if (s.contains(".")) {
				res = Math.max(res, len - 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}
}
