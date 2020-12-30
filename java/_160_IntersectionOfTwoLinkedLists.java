/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._160_IntersectionOfTwoLinkedLists
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 相交链表
 * @author lilin
 * @date 2020-12-29 19:48
 */
public class _160_IntersectionOfTwoLinkedLists {
	/*
	编写一个程序，找到两个单链表相交的起始节点。
	参考官解
	 */

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(getIntersectionNode(ListNode.build("[1,2,3,4]"), ListNode.build("[40,50]")));
	}
}
