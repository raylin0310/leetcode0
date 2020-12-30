/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._083_RemoveDuplicatesFromSortedList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 删除排序链表中的重复元素
 * @author lilin
 * @date 2020-12-29 14:09
 */
public class _083_RemoveDuplicatesFromSortedList {
	/*
	给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

	示例1:
	
	输入: 1->1->2
	输出: 1->2
	示例2:
	
	输入: 1->1->2->3->3
	输出: 1->2->3
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		System.out.println(deleteDuplicates(ListNode.build("[1,1,2,2,3,4,5]")));
	}
}
