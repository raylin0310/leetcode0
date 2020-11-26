/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._109_ConvertSortedListToBinarySearchTree
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 有序链表转换二叉搜索树
 * @author lilin
 * @date 2020-11-26 14:45
 */
public class _109_ConvertSortedListToBinarySearchTree {
	/*
	给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

	本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
	
	示例:
	
	给定的有序链表： [-10, -3, 0, 5, 9],
	
	一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
	
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	时间复杂度：O(nlogn)，其中 n 是链表的长度。

	空间复杂度：O(logn)，即为递归过程中栈的最大深度，也就是需要的空间。

	 */

	public static TreeNode sortedListToBST(ListNode head) {
		return toBST(head, null);
	}

	public static TreeNode toBST(ListNode left, ListNode right) {
		if (left == right) {
			return null;
		}

		ListNode mid = getMid(left, right);
		TreeNode root = new TreeNode(mid.val);
		root.left = toBST(left, mid);
		root.right = toBST(mid.next, right);
		return root;
	}

	// 找链表的中位数，快慢指针，这里的mid是偏左的，即[a,b]，left=a,right=b -> mid=a
	// 如果left=a,right=null ->mid = b
	// 参考876题：链表的中间节点

	public static ListNode getMid(ListNode left, ListNode right) {
		ListNode slow = left;
		ListNode fast = left;
		while (fast != right && fast.next != right) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	/*
	优化版本，中序遍历
	 */


	ListNode globalHead;

	public TreeNode sortedListToBST2(ListNode head) {
		globalHead = head;
		int length = getLength(head);
		return buildTree(0, length - 1);
	}

	public int getLength(ListNode head) {
		int ret = 0;
		while (head != null) {
			++ret;
			head = head.next;
		}
		return ret;
	}

	public TreeNode buildTree(int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right + 1) / 2;
		TreeNode root = new TreeNode();
		root.left = buildTree(left, mid - 1);
		root.val = globalHead.val;
		globalHead = globalHead.next;
		root.right = buildTree(mid + 1, right);
		return root;
	}

	public static void main(String[] args) {
		System.out.println(sortedListToBST(ListNode.build("[1,2]")));
	}
}
