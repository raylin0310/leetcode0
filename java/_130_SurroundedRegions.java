/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._130_SurroundedRegions
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 被围绕的区域
 * @author lilin
 * @date 2021-1-4 17:51
 */
public class _130_SurroundedRegions {
	/*
	给定一个二维的矩阵，包含'X'和'O'（字母 O）。

	找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
	
	示例:
	
	X X X X
	X O O X
	X X O X
	X O X X
	运行你的函数后，矩阵变为：
	
	X X X X
	X X X X
	X X X X
	X O X X
	解释:
	被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
	任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/surrounded-regions
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	详细见官解
	https://leetcode-cn.com/problems/surrounded-regions/solution/bei-wei-rao-de-qu-yu-by-leetcode-solution/

	首先找到突破口，就是不满足被包围的情况，即边界上等于O的坐标，顺着这个左边开始搜索，把相邻的都设置成另外一个值1，
	当边界情况都找出来后，开始一层一层遍历二维数组，当为0时，满足要求，设置为X，当为1时，这个是与边界相连的，我们还原回来，设置为0
	 */

	public static void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int m = board.length - 1;
		int n = board[0].length - 1;
		//边界的O
		for (int i = 0; i <= m; i++) {
			// 左边界
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			//右边界
			if (board[i][n] == 'O') {
				dfs(board, i, n);
			}
		}
		for (int i = 0; i <= n; i++) {
			//上边界
			if (board[0][i] == 'O') {
				dfs(board, 0, i);
			}
			// 下边界
			if (board[m][i] == 'O') {
				dfs(board, m, i);
			}
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '1') {
					//还原
					board[i][j] = 'O';
				}
			}
		}
	}

	private static void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
			return;
		}
		board[i][j] = '1';
		dfs(board, i, j + 1);
		dfs(board, i, j - 1);
		dfs(board, i + 1, j);
		dfs(board, i - 1, j);
	}


	class Point {
		int x;
		int y;

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	/*
	BFS
	 */

	public void solve2(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int m = board.length - 1;
		int n = board[0].length - 1;
		Queue<Point> queue = new LinkedList<>();
		//也可以直接用int[]一维数组表示xy坐标
		//Queue<int[]> queue = new LinkedList<>();

		//get all 'O's on the edge first
		for (int r = 0; r <= m; r++) {
			if (board[r][0] == 'O') {
				board[r][0] = '1';
				queue.add(new Point(r, 0));
			}
			if (board[r][n] == 'O') {
				board[r][n] = '1';
				queue.add(new Point(r, n));
			}
		}

		for (int i = 0; i < n; i++){
			if (board[0][i] == 'O') {
				board[0][i] = '1';
				queue.add(new Point(0, i));
			}
			if (board[m][i] == 'O') {
				board[m][i] = '1';
				queue.add(new Point(m, i));
			}
		}
		//队列里面的都是边界为O的，开始从上下左右开始扩散
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int row = p.x;
			int col = p.y;
			//上
			if (row - 1 >= 0 && board[row - 1][col] == 'O') {
				board[row - 1][col] = '1';
				queue.add(new Point(row - 1, col));
			}
			//下
			if (row + 1 < m && board[row + 1][col] == 'O') {
				board[row + 1][col] = '1'; queue.add(new Point(row + 1, col));
			}
			//左
			if (col - 1 >= 0 && board[row][col - 1] == 'O') {
				board[row][col - 1] = '1';
				queue.add(new Point(row, col - 1));
			}
			//右
			if (col + 1 < n && board[row][col + 1] == 'O') {
				board[row][col + 1] = '1';
				queue.add(new Point(row, col + 1));
			}
		}

		for (int i = 0; i<= m; i++){
			for (int j=0; j<= n; j++){
				//不是边界的O
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				//还原
				if (board[i][j] == '1') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}
