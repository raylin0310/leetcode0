/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._158_ReadNCharactersGivenRead4IICallMultipleTimes
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _158_ReadNCharactersGivenRead4IICallMultipleTimes
 * @author lilin
 * @date 2020-9-23 13:38
 */
public class _158_ReadNCharactersGivenRead4IICallMultipleTimes {
	/*
	给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。
	注意：你的 read 方法可能会被调用多次。
	read4 和 read 的定义与No.157一致。

	File file("abc");
	Solution sol;
	假定 buf 已经被分配了内存，并且有足够的空间来存储文件中的所有字符。
	sol.read(buf, 1); // 当调用了您的 read 方法后，buf 需要包含 "a"。 一共读取 1 个字符，因此返回 1。
	sol.read(buf, 2); // 现在 buf 需要包含 "bc"。一共读取 2 个字符，因此返回 2。
	sol.read(buf, 1); // 由于已经到达了文件末尾，没有更多的字符可以读取，因此返回 0。
	 */

	private int count = 0;
	private int pointer = 0;
	private char[] temp = new char[4];

	public int read(char[] buf, int n) {
		int index = 0;
		while (index < n) {
			if (pointer == 0) {
				count = read4(temp);
			}
			if (count == 0) {
				break;
			}
			while (index < n && pointer < count) {
				buf[index++] = temp[pointer++];
			}
			if (pointer == count) {
				pointer = 0;
			}
		}
		return index;
	}

	//辅助函数，正常不是这么写
	public int read4(char[] temp) {
		char[] res = new char[10];
		char[] ret = new char[4];
		int index = 0;
		for (int i = 0; i < res.length; i++) {
			if (index < 4){
				ret[index++] = temp[i];
			}
		}
		return index;
	}
}
