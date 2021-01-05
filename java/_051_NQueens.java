/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._051_NQueens
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * @author lilin
 * @date 2021-1-5 10:26
 */
public class _051_NQueens {
	/*
	这个题解，采用回溯算法，简单易懂，厉害
	https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-jing-dian-hui-su-suan-fa-tu-wen-xiang-j/
	 */

	public List<List<String>> solveNQueens(int n) {
		char[][] chess = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chess[i][j] = '.';
			}
		}
		List<List<String>> res = new ArrayList<>();
		solve(res, chess, 0);
		return res;
	}

	//回溯
	private void solve(List<List<String>> res, char[][] chess, int row) {
		if (row == chess.length) {
			res.add(construct(chess));
			return;
		}
		for (int col = 0; col < chess.length; col++) {
			if (valid(chess, row, col)) {
				chess[row][col] = 'Q';
				//一行只能放一个，去下一行寻找放的位置
				solve(res, chess, row + 1);
				chess[row][col] = '.';
			}
		}
	}

	//row表示第几行，col表示第几列
	private boolean valid(char[][] chess, int row, int col) {
		//判断当前列有没有皇后,因为他是一行一行往下走的，
		//我们只需要检查走过的行数即可，通俗一点就是判断当前
		//坐标位置的上面有没有皇后
		for (int i = 0; i < row; i++) {
			if (chess[i][col] == 'Q') {
				return false;
			}
		}
		//判断当前坐标的右上角有没有皇后
		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] == 'Q') {
				return false;
			}
		}
		//判断当前坐标的左上角有没有皇后
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}

	//把数组转为list
	private List<String> construct(char[][] chess) {
		List<String> path = new ArrayList<>();
		for (int i = 0; i < chess.length; i++) {
			path.add(new String(chess[i]));
		}
		return path;
	}

	public static void main(String[] args) {
		_051_NQueens test = new _051_NQueens();
		List<List<String>> lists = test.solveNQueens(8);
		print(lists.get(0));

	}

	public static void print(List<String> list) {
		for (String s : list) {
			char[] chars = s.toCharArray();
			for (char aChar : chars) {
				System.out.print(aChar + "\t");
			}
			System.out.println();
		}
	}
}
