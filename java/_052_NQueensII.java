/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._052_NQueensII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _052_NQueensII
 * @author lilin
 * @date 2021-1-5 11:07
 */
public class _052_NQueensII {
	/*
	跟51题一样，只是返回的是方案数量，不返回具体方案
	 */
	int res = 0;

	public int totalNQueens(int n) {
		if (n <= 0) {
			return res;
		}
		char[][] chars = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chars[i][j] = '.';
			}
		}
		solve(chars, 0);
		return res;
	}

	public void solve(char[][] chars, int row) {
		if (row == chars.length) {
			res++;
			return;
		}
		for (int col = 0; col < chars.length; col++) {
			if (valid(chars, row, col)) {
				chars[row][col] = 'Q';
				//寻找下一行
				solve(chars, row + 1);
				chars[row][col] = '.';
			}
		}
	}

	public boolean valid(char[][] chars, int row, int col) {
		//检查正上方
		for (int i = 0; i < row; i++) {
			if (chars[i][col] == 'Q') {
				return false;
			}
		}
		//检查右上方
		for (int i = row - 1, j = col + 1; i >= 0 && j < chars.length; i--, j++) {
			if (chars[i][j] == 'Q') {
				return false;
			}
		}
		//检查左上方
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chars[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		_052_NQueensII test = new _052_NQueensII();
		System.out.println(test.totalNQueens(4));
	}
}
