/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._099_RecoverBinarySearchTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 恢复二叉搜索树
 * @author lilin
 * @date 2020-12-2 14:05
 */
public class _099_RecoverBinarySearchTree {
	/*
	给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。

	进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
	
	示例 1：

	输入：root = [1,3,null,null,2]
	输出：[3,1,null,null,2]
	解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
	示例 2：

	输入：root = [3,1,4,null,null,2]
	输出：[2,1,4,null,null,3]
	解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。

	提示：
	
	树上节点的数目在范围 [2, 1000] 内
	-231 <= Node.val <= 231 - 1
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/recover-binary-search-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 官方题解
	 先中序遍历root，找出被交换了的两个节点val，在迭代root，交换xy
	 */

	static class Solution {
		public void recoverTree(TreeNode root) {
			List<Integer> nums = new ArrayList<>();
			inorder(root, nums);
			int[] swapped = findTwoSwapped(nums);
			recover(root, 2, swapped[0], swapped[1]);
		}

		public void inorder(TreeNode root, List<Integer> nums) {
			if (root == null) {
				return;
			}
			inorder(root.left, nums);
			nums.add(root.val);
			inorder(root.right, nums);
		}

		public int[] findTwoSwapped(List<Integer> nums) {
			int n = nums.size();
			int x = -1, y = -1;
			for (int i = 0; i < n - 1; ++i) {
				if (nums.get(i + 1) < nums.get(i)) {
					y = nums.get(i + 1);
					if (x == -1) {
						x = nums.get(i);
					} else {
						break;
					}
				}
			}
			return new int[]{x, y};
		}

		public void recover(TreeNode root, int count, int x, int y) {
			if (root != null) {
				if (root.val == x || root.val == y) {
					root.val = root.val == x ? y : x;
					if (--count == 0) {
						return;
					}
				}
				recover(root.right, count, x, y);
				recover(root.left, count, x, y);
			}
		}
	}

	/*
	隐式中序遍历（迭代方式）

	[1,2,3,4,5,6,7]  -> [1,6,3,4,5,2,7]
	 */

	static class Solution2 {

		public void recoverTree(TreeNode root) {
			Deque<TreeNode> stack = new LinkedList<>();
			TreeNode x = null, y = null, pred = null;

			while (root != null || !stack.isEmpty()) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				root = stack.pop();
				if (pred != null && root.val < pred.val) {
					// 这里赋值，而不是写到下面else里面的原因是
					// 如果交换的节点是相邻的情况下
					//即中序1,2,3 -> 2,1,3 ，此时y=1,x=2，如果放到else里面，则y就是null
					y = root;
					if (x == null) {
						x = pred;
					} else {
						break;
					}
				}
				pred = root;
				root = root.right;
			}

			swap(x, y);
		}

		//Morris 遍历算法

		public void recoverTree2(TreeNode root) {
			TreeNode x = null, y = null, pred = null, predecessor = null;

			while (root != null) {
				if (root.left != null) {
					// predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
					predecessor = root.left;
					while (predecessor.right != null && predecessor.right != root) {
						predecessor = predecessor.right;
					}

					// 让 predecessor 的右指针指向 root，继续遍历左子树
					if (predecessor.right == null) {
						predecessor.right = root;
						root = root.left;
					} else {
						// 说明左子树已经访问完了，我们需要断开链接
						if (pred != null && root.val < pred.val) {
							y = root;
							if (x == null) {
								x = pred;
							}
						}
						pred = root;

						predecessor.right = null;
						root = root.right;
					}
				} else {
					// 如果没有左孩子，则直接访问右孩子
					if (pred != null && root.val < pred.val) {
						y = root;
						if (x == null) {
							x = pred;
						}
					}
					pred = root;
					root = root.right;
				}
			}
			swap(x, y);
		}

		public void swap(TreeNode x, TreeNode y) {
			int tmp = x.val;
			x.val = y.val;
			y.val = tmp;
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.stringToTreeNode("[3,1,4,null,null,2]");
		Solution2 s2 = new Solution2();
		s2.recoverTree(root);
		System.out.println(root);
	}


}
