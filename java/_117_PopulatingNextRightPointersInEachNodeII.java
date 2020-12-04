/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._117_PopulatingNextRightPointersInEachNodeII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 II
 * @author lilin
 * @date 2020-12-3 13:59
 */
public class _117_PopulatingNextRightPointersInEachNodeII {


	public static Node connect(Node root) {
		Node head = null;
		Node pre = null;
		Node cur = root;
		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (pre != null) {
						pre.next = cur.left;
					} else {
						head = cur.left;
					}
					pre = cur.left;
				}
				if (cur.right != null) {
					if (pre != null) {
						pre.next = cur.right;
					} else {
						head = cur.right;
					}
					pre = cur.right;
				}
				// 指针向后移动
				cur = cur.next;
			}
			// 去下一层的最左的节点
			cur = head;
			pre = null;
			head = null;
		}
		return root;
	}

	public static void main(String[] args) {
		connect(Node.stringToTreeNode("[1,2,3,4,5,null,7]"));
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

		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					'}';
		}

		public static Node stringToTreeNode(String input) {
			input = input.trim();
			input = input.substring(1, input.length() - 1);
			if (input.length() == 0) {
				return null;
			}

			String[] parts = input.split(",");
			String item = parts[0];
			Node root = new Node(Integer.parseInt(item));
			Queue<Node> nodeQueue = new LinkedList<>();
			nodeQueue.add(root);

			int index = 1;
			while (!nodeQueue.isEmpty()) {
				Node node = nodeQueue.remove();

				if (index == parts.length) {
					break;
				}

				item = parts[index++];
				item = item.trim();
				if (!item.equals("null")) {
					int leftNumber = Integer.parseInt(item);
					node.left = new Node(leftNumber);
					nodeQueue.add(node.left);
				}

				if (index == parts.length) {
					break;
				}

				item = parts[index++];
				item = item.trim();
				if (!item.equals("null")) {
					int rightNumber = Integer.parseInt(item);
					node.right = new Node(rightNumber);
					nodeQueue.add(node.right);
				}
			}
			return root;
		}
	}
}
