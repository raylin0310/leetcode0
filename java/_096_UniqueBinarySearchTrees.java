/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._096_UniqueBinarySearchTrees
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 不同的二叉搜索树
 * @author lilin
 * @date 2020-12-7 13:46
 */
public class _096_UniqueBinarySearchTrees {
	/*
	给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？

	示例:

	输入: 3
	输出: 5
	解释:
	给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/unique-binary-search-trees
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	参考官方题解
	 */

	public int numTrees(int n) {
		int[] G = new int[n + 1];
		G[0] = 1;
		G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}


}
