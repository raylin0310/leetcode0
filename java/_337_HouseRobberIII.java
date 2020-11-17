/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._337_HouseRobberIII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III
 * @author lilin
 * @date 2020-11-17 10:13
 */
public class _337_HouseRobberIII {
	/*
	在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
	除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
	如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

	计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
	
	示例 1:
	
	输入: [3,2,3,null,3,null,1]
	
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
	
	输出: 7 
	解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
	示例 2:
	
	输入: [3,4,5,1,3,null,1]
	
	    3
	    / \
	   4   5
	  / \   \ 
	 1   3   1
	
	输出: 9
	解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/house-robber-iii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	思路：https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
	非常棒，一步一步优化
	中文版的：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
	 */


	public static int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int val = 0;
		if (root.left != null) {
			val += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			val += rob(root.right.left) + rob(root.right.right);
		}
		//val+root.val表示偷当前节点的，后面表示偷左右节点的，最后取最大值，
		return Math.max(val + root.val, rob(root.left) + rob(root.right));
	}

	public static int rob2(TreeNode root) {
		return robSub(root, new HashMap<>());
	}

	private static int robSub(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) return 0;
		if (map.containsKey(root)) return map.get(root);

		int val = 0;

		if (root.left != null) {
			val += robSub(root.left.left, map) + robSub(root.left.right, map);
		}

		if (root.right != null) {
			val += robSub(root.right.left, map) + robSub(root.right.right, map);
		}

		val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
		map.put(root, val);

		return val;
	}



	/*
	第一个元素表示如果未盗用root则可以盗用的最大金额，而第二个元素表示如果被盗取则可以盗用的最大金额。
	任何一个节点能偷到的最大钱的状态可以定义为

	当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
	当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数

	作者：reals
	链接：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */

	public int rob3(TreeNode root) {
		int[] res = robSub2(root);
		return Math.max(res[0], res[1]);
	}

	private int[] robSub2(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int[] left = robSub2(root.left);
		int[] right = robSub2(root.right);
		int[] res = new int[2];
		//当前节点不选择偷的情况，左右节点偷不偷不关心，只需要取左右节点“钱”的最大值即可
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		//当前节点选择偷，那左右节点就只能选择不偷时的值
		res[1] = root.val + left[0] + right[0];

		return res;
	}


	public static void main(String[] args) {
		System.out.println(rob(TreeNode.stringToTreeNode("[9,2,3]")));
	}
}
