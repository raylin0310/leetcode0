/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._203_RemoveLinkedListElements
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 移除链表元素
 * @author lilin
 * @date 2020-12-29 14:18
 */
public class _203_RemoveLinkedListElements {

	/*
	删除链表中等于给定值 val 的所有节点。

	示例:

	输入: 1->2->6->3->4->5->6, val = 6
	输出: 1->2->3->4->5
	 */

	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println(removeElements(ListNode.build("[1,2,3,5,6,4,3,2,6]"), 1));
	}
}
