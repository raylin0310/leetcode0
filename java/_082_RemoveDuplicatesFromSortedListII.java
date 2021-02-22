/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._082_RemoveDuplicatesFromSortedListII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 删除排序链表中的重复元素 II
 * @author lilin
 * @date 2020-12-29 14:26
 */
public class _082_RemoveDuplicatesFromSortedListII {
	/*
	给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。

	示例1:
	
	输入: 1->2->3->3->4->4->5
	输出: 1->2->5
	示例2:
	
	输入: 1->1->1->2->3
	输出: 2->3
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		// 1,1,1,2,3,3
		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int sameNum = p.next.val;
				// 把p节点后面挨着的等于1的节点都删除，跳出循环后，p=[0,2,3,3]
				while (p.next != null && p.next.val == sameNum) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}
		}
		return dummy.next;
	}


	public static void main(String[] args) {
		System.out.println(deleteDuplicates(ListNode.build("[1,1,1,2,3,3]")));
	}
}
