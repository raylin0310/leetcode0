/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._142_LinkedListCycleII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 环形链表 II
 * @author lilin
 * @date 2020-12-30 14:52
 */
public class _142_LinkedListCycleII {
	/*
	给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。

	为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
	如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
	
	说明：不允许修改给定的链表。
	
	进阶：
	
	你是否可以使用 O(1) 空间解决此题？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				// 第一次相遇后，fast/slow继续走，另一个从头开始走，再次相遇即为入环点
				while (head != fast) {
					fast = fast.next;
					head = head.next;
				}
				return head;
			}
		}
		return null;
	}


}
