/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._206_ReverseLinkedList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 反转链表 II
 * @author lilin
 * @date 2020-12-28 14:35
 */
public class _206_ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode temp = head.next;
			// 相当于一直在链表头部添加node
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}

	public static void main(String[] args) {
		System.out.println(reverseList(ListNode.build("[1,2,3,4]")));
	}
}
