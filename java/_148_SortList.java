/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._148_SortList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 排序链表
 * @author lilin
 * @date 2020-12-30 15:18
 */
public class _148_SortList {
	/*
	给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。

	进阶：
	
	你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/sort-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		return sort(head);
	}

	public static ListNode sort(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode l2 = mid.next;
		//断开
		mid.next = null;
		// 分左半部分
		ListNode left = sort(head);
		// 分右半部分
		ListNode right = sort(l2);
		// 归
		return mergeTwoLists(left, right);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		} else {
			cur.next = l2;
		}
		return dummy.next;
	}

	// 找中节点，如果是偶数个，中节点是偏左

	public static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}


	public static ListNode sortList2(ListNode head) {
		if (head == null) {
			return head;
		}
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		ListNode dummyHead = new ListNode(0, head);
		for (int subLength = 1; subLength < length; subLength <<= 1) {
			ListNode prev = dummyHead;
			ListNode curr = dummyHead.next;
			while (curr != null) {
				ListNode head1 = curr;
				for (int i = 1; i < subLength && curr.next != null; i++) {
					curr = curr.next;
				}
				ListNode head2 = curr.next;
				curr.next = null;
				curr = head2;
				for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
					curr = curr.next;
				}
				ListNode next = null;
				if (curr != null) {
					next = curr.next;
					curr.next = null;
				}
				ListNode merged = mergeTwoLists(head1, head2);
				prev.next = merged;
				while (prev.next != null) {
					prev = prev.next;
				}
				curr = next;
			}
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.build("[4,2,1,3,6,8]");
		System.out.println(sortList2(head));
	}
}
