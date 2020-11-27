/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._173_BinarySearchTreeIterator
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉搜索树迭代器
 * @author lilin
 * @date 2020-11-27 10:45
 */
public class _173_BinarySearchTreeIterator {
	/*
	实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

	调用 next() 将返回二叉搜索树中的下一个最小的数。

	示例：

	BSTIterator iterator = new BSTIterator(root);
	iterator.next();    // 返回 3
	iterator.next();    // 返回 7
	iterator.hasNext(); // 返回 true
	iterator.next();    // 返回 9
	iterator.hasNext(); // 返回 true
	iterator.next();    // 返回 15
	iterator.hasNext(); // 返回 true
	iterator.next();    // 返回 20
	iterator.hasNext(); // 返回 false
	
	提示：

	next()和hasNext()操作的时间复杂度是O(1)，并使用O(h) 内存，其中h是树的高度。
	你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 中至少存在一个下一个最小的数。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
		第一种方式：由于是二叉搜索树，中序遍历结果是顺序的，初始化时，保存中序遍历结果，用一个指针来操作next和hasNext
		详见官方题解：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/，
		但是这种的控件复杂度是O(n);
		第二种方式：用stack模拟线程栈，详见上面官方题解
	 */

	static class BSTIterator {

		Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {

			// Stack for the recursion simulation
			this.stack = new Stack<>();

			// Remember that the algorithm starts with a call to the helper function
			// with the root node as the input
			this._leftmostInorder(root);
		}

		private void _leftmostInorder(TreeNode root) {

			// For a given node, add all the elements in the leftmost branch of the tree
			// under it to the stack.
			while (root != null) {
				this.stack.push(root);
				root = root.left;
			}
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			// Node at the top of the stack is the next smallest element
			TreeNode topmostNode = this.stack.pop();

			// Need to maintain the invariant. If the node has a right child, call the
			// helper function for the right child
			//我们不需要检查左节点，因为左节点已经添加到栈中了。栈顶元素要么没有左节点，要么左节点已经被处理了。
			// 如果栈顶部拥有右节点，那么我们需要对右节点上调用帮助函数。该时间复杂度取决于树的结构。
			if (topmostNode.right != null) {
				this._leftmostInorder(topmostNode.right);
			}

			return topmostNode.val;
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return this.stack.size() > 0;
		}
	}


	static class BSTIterator2 {

		ArrayList<Integer> nodesSorted;
		int index;

		public BSTIterator2(TreeNode root) {

			// Array containing all the nodes in the sorted order
			this.nodesSorted = new ArrayList<>();

			// Pointer to the next smallest element in the BST
			this.index = -1;

			// Call to flatten the input binary search tree
			this._inorder(root);
		}

		private void _inorder(TreeNode root) {

			if (root == null) {
				return;
			}

			this._inorder(root.left);
			this.nodesSorted.add(root.val);
			this._inorder(root.right);
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			return this.nodesSorted.get(++this.index);
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return this.index + 1 < this.nodesSorted.size();
		}
	}
}


