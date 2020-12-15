/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._060_PermutationSequence
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 排列序列
 * @author lilin
 * @date 2020-12-15 19:52
 */
public class _060_PermutationSequence {
	/*
	给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。

	按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	给定n 和k，返回第k个排列。
	
	示例 1：
	
	输入：n = 3, k = 3
	输出："213"
	示例 2：
	
	输入：n = 4, k = 9
	输出："2314"
	示例 3：
	
	输入：n = 3, k = 1
	输出："123"
	
	
	提示：
	
	1 <= n <= 9
	1 <= k <= n!
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/permutation-sequence
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	题解参考liweiwei
	https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
	 */

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getPermutation(4, 15));
	}

	static class Solution {

		/**
		 * 记录数字是否使用过
		 */
		private boolean[] used;

		/**
		 * 阶乘数组
		 */
		private int[] factorial;

		private int n;
		private int k;

		public String getPermutation(int n, int k) {
			this.n = n;
			this.k = k;
			// 计算一共有多少个排列
			calculateFactorial(n);

			// 查找全排列需要的布尔数组
			used = new boolean[n + 1];
			StringBuilder path = new StringBuilder();
			dfs(0, path);
			return path.toString();
		}


		/**
		 * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
		 * @param path
		 */
		private void dfs(int index, StringBuilder path) {
			if (index == n) {
				return;
			}

			// 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
			int cnt = factorial[n - 1 - index];
			for (int i = 1; i <= n; i++) {
				if (used[i]) {
					continue;
				}
				// cnt表示这一节点分支下面所有排列的个数，如果小于k，说明肯定不在这一分支
				// 那么久切换到下一个分支，重复
				if (cnt < k) {
					k -= cnt;
					continue;
				}
				path.append(i);
				used[i] = true;
				dfs(index + 1, path);
				// 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
				// 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
				return;
			}
		}

		/**
		 * 计算阶乘数组
		 *
		 * @param n
		 */
		private void calculateFactorial(int n) {
			factorial = new int[n + 1];
			factorial[0] = 1;
			for (int i = 1; i <= n; i++) {
				factorial[i] = factorial[i - 1] * i;
			}
		}
	}
}
