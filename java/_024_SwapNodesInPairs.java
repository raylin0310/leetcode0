/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._024_SwapNodesInPairs
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 两两交换链表中的节点
 * @author lilin
 * @date 2020-12-28 16:09
 */
public class _024_SwapNodesInPairs {
	/*
	给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	 */

	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		while (current.next != null && current.next.next != null) {
			ListNode first = current.next;
			ListNode second = current.next.next;
			// 1,2,3,4,5,6
			// 1的next指向3,2的next指向1即可
			/*
			 1->2->3->4
			 -------------
			 1->
			     3->4
			 2->
			 ------------
			 2->1->
			       3->4
			-------------
			 */
			first.next = second.next;
			second.next = first;

			current.next = second;

			current = current.next.next;
		}
		return dummy.next;
	}
	/*
	 同上，复习时自己写的
	 */

	public static ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		while (current.next != null && current.next.next != null) {
			ListNode n = current.next;
			ListNode nn = n.next;
			ListNode nnn = nn.next;
			n.next = nnn;
			nn.next = n;
			current.next = nn;
			current = n;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println(swapPairs(ListNode.build("[1,2,3,4,5]")));
		System.out.println(swapPairs2(ListNode.build("[1,2,3,4,5]")));
	}
}
