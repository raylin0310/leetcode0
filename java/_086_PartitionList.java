/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._086_PartitionList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 分隔链表
 * @author lilin
 * @date 2020-12-31 10:54
 */
public class _086_PartitionList {
	/*
	给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

	你应当保留两个分区中每个节点的初始相对位置。

	示例:
	
	输入: head = 1->4->3->2->5->2, x = 3
	输出: 1->2->2->4->3->5
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/partition-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
		参考官解
		https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode/
		分成两个head（small、big），small放所有比x的node，big放所有比X大的node，最后把big接在small的最后面
	 */

	public static ListNode partition(ListNode head, int x) {
		ListNode smallHead = new ListNode(0);
		ListNode bigHead = new ListNode(0);
		ListNode small = smallHead;
		ListNode big = bigHead;
		while (head != null) {
			ListNode temp = new ListNode(head.val);
			if (head.val < x) {
				small.next = temp;
				small = small.next;
			} else {
				big.next = temp;
				big = big.next;
			}
			head = head.next;
		}
		small.next = bigHead.next;
		return smallHead.next;
	}

	public static void main(String[] args) {
		System.out.println(partition(ListNode.build("[1,4,3,2,5,2]"), 3));
	}
}
