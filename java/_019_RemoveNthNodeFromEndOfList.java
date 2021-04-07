/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._019_RemoveNthNodeFromEndOfList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 删除链表的倒数第N个节点
 * @author lilin
 * @date 2020-12-29 13:40
 */
public class _019_RemoveNthNodeFromEndOfList {
	/*
	给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。

	示例：
	
	给定一个链表: 1->2->3->4->5, 和 n = 2.
	
	当删除了倒数第二个节点后，链表变为 1->2->3->5.
	说明：
	
	给定的 n保证是有效的。
	
	进阶：
	
	你能尝试使用一趟扫描实现吗？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 time:O(l)
	 space:O(1)
	 */

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0  || head == null) {
			return head;
		}

		ListNode right = head;
		ListNode left = head;
		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		// 此时就是删除头节点
		if (right == null) {
			return head.next;
		}
		while (right.next != null) {
			right = right.next;
			left = left.next;
		}
		// 此时left是倒数第n+1个
		left.next = left.next.next;
		return head;
	}

	// 用dummy节点，可以避免考虑头节点的情况

	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy;
		ListNode fast = dummy;
		dummy.next = head;
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println(removeNthFromEnd2(ListNode.build("[1,2,3,4,5,6,7,8,9]"), 2));
	}
}
