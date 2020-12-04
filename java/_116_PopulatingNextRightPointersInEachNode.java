/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._116_PopulatingNextRightPointersInEachNode
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 填充每个节点的下一个右侧节点指针
 * @author lilin
 * @date 2020-12-3 13:42
 */
public class _116_PopulatingNextRightPointersInEachNode {
	/*
	给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

	struct Node {
	  int val;
	  Node *left;
	  Node *right;
	  Node *next;
	}
	填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
	
	初始状态下，所有next 指针都被设置为 NULL。

	进阶：
	
	你只能使用常量级额外空间。
	使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.right != null && root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
		return root;
	}

	public Node connect2(Node root) {
		if (root == null) {
			return root;
		}

		// 从根节点开始
		Node leftmost = root;

		while (leftmost.left != null) {

			// 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
			Node head = leftmost;

			while (head != null) {

				// CONNECTION 1
				head.left.next = head.right;

				// CONNECTION 2
				if (head.next != null) {
					head.right.next = head.next.left;
				}

				// 指针向后移动
				head = head.next;
			}

			// 去下一层的最左的节点
			leftmost = leftmost.left;
		}

		return root;
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}
