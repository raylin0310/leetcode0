/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._157_ReadNCharactersGivenRead4
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _157_ReadNCharactersGivenRead4
 * @author lilin
 * @date 2020-9-23 11:03
 */
public class _157_ReadNCharactersGivenRead4 {
	/*
	给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。返回值为实际读取的字符个数。
	输入： file = "abc", n = 4
	输出： 3
	解释： 当执行你的 rand 方法后，buf 需要包含 "abc"。 文件一共 3 个字符，因此返回 3。
	注意 "abc" 是文件的内容，不是 buf 的内容，buf 是你需要写入结果的目标缓存区。
	 */

	public int read(char[] buf, int n) {
		char[] temp = new char[4];
		int index = 0;
		while (true) {
			int count = read4(temp);
			count = Math.min(count, n - index);
			for (int i = 0; i < count; i++) {
				buf[index++] = temp[i];
			}
			if (index == n || count < 4) {
				return index;
			}
		}
	}

	//辅助函数，正常不是这么写
	public static int read4(char[] temp) {
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

	public static void main(String[] args) {

	}
}
