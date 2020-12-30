/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._021_MergeTwoSortedLists
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 合并两个有序链表
 * @author lilin
 * @date 2020-12-29 20:04
 */
public class _021_MergeTwoSortedLists {
	/*
	将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

	示例：
	
	输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				cur.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			cur = cur.next;
		}
		while (l1 != null) {
			cur.next = new ListNode(l1.val);
			l1 = l1.next;
			cur = cur.next;
		}
		while (l2 != null) {
			cur.next = new ListNode(l2.val);
			l2 = l2.next;
			cur = cur.next;
		}
		return dummy.next;
	}

	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
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

	public static void main(String[] args) {
		ListNode l1 = ListNode.build("[1,3,5,7,9]");
		ListNode l2 = ListNode.build("[1,2,4,6,8,10]");
		System.out.println(mergeTwoLists(l1, l2));
	}
}
