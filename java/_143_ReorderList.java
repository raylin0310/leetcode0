/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._143_ReorderList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 重排链表
 * @author lilin
 * @date 2020-12-30 10:44
 */
public class _143_ReorderList {
	
	/*
	给定一个单链表L：L0→L1→…→Ln-1→Ln ，
	将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
	
	你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	
	示例1:
	
	给定链表 1->2->3->4, 重新排列为 1->4->2->3.
	示例 2:
	
	给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reorder-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	寻找链表中点 + 链表逆序 + 合并链表
	 还有一种方法，我们是找的中点，当是偶数的时候，偏右的，
	 可以换成偏左的，然后mid.next=null，断开，分成两个l1,l2调用mergeList就好处理了
	 参考官解
	 */


	public static void main(String[] args) {
		//1、4、2、3
		ListNode head = ListNode.build("[1,2,3,4]");
		reorderList(head);
		System.out.println(head);
	}

	/*
	 time:O(n)
	 space:O(1)
	 */

	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		// 偏左
		ListNode mid = middleNode(head);
		ListNode l1 = head;
		ListNode l2 = mid.next;
		//断开
		mid.next = null;
		l2 = reverse(l2);
		mergeList(l1, l2);
		System.out.println("l1+"+l1.toString());
	}

	/*
	中节点偏左
	偏右：fast != null && fast.next != null
	 */

	public static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	//这里如果要返回合并后的链表，参考148题

	public static void mergeList(ListNode l1, ListNode l2) {
		ListNode l1Next;
		ListNode l2Next;
		while (l1 != null && l2 != null) {
			l1Next = l1.next;
			l2Next = l2.next;

			l1.next = l2;
			l2.next = l1Next;

			l1 = l1Next;
			l2 = l2Next;
		}
	}

	public static ListNode reverse(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}

}
