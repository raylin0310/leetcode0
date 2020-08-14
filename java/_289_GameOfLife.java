/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._289_GameOfLife
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _289_GameOfLife
 * @author lilin
 * @date 2020-8-11 14:51
 */
public class _289_GameOfLife {

	/*
		 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
		
		 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
		 1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
		
		 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
		 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
		 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
		 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
		 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
		
		
		
		 示例：
		
		 输入： 
		 [
		  [0,1,0],
		  [0,0,1],
		  [1,1,1],
		  [0,0,0]
		 ]
		 输出：
		 [
		  [0,0,0],
		  [1,0,1],
		  [0,1,1],
		  [0,1,0]
		 ]
		
		
		 进阶：
		
		 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
		 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
		
		 来源：力扣（LeetCode）
		 链接：https://leetcode-cn.com/problems/game-of-life
		 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
		
		 可查看官方题解：https://leetcode-cn.com/problems/game-of-life/solution/sheng-ming-you-xi-by-leetcode-solution/
		 用状态去减少空间复杂度
	 */


	public static void gameOfLife(int[][] board) {

		int rows = board.length;
		int cols = board[0].length;

		// 创建复制数组 copyBoard
		int[][] copyBoard = new int[rows][cols];

		// 从原数组复制一份到 copyBoard 中
		for (int row = 0; row < rows; row++) {
			System.arraycopy(board[row], 0, copyBoard[row], 0, cols);
		}

		int[][] dirs = {
				{-1, -1},//左上
				{-1, 0}, //中上
				{-1, 1},
				{0, 1},
				{1, 1},
				{1, 0},
				{1, -1},
				{0, -1},
		};

		// 遍历面板每一个格子里的细胞
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {

				// 对于每一个细胞统计其八个相邻位置里的活细胞数量
				int liveNeighbors = 0;

				for (int[] dir : dirs) {
					int r = (row + dir[0]);
					int c = (col + dir[1]);
					// 查看相邻的细胞是否是活细胞
					if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
						liveNeighbors += 1;
					}
				}

				// 规则 1 或规则 3
				if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
					board[row][col] = 0;
				}
				// 规则 4
				if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
					board[row][col] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] nums = {
				{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
		};
		gameOfLife(nums);
		ArrayUtil.toString(nums);
	}
}

