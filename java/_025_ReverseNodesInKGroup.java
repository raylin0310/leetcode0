/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._025_ReverseNodesInKGroup
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 *  K 个一组翻转链表
 * @author lilin
 * @date 2020-12-30 19:09
 */
public class _025_ReverseNodesInKGroup {
	/*
	给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。

	k是一个正整数，它的值小于或等于链表的长度。
	
	如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
	
	示例：
	
	给你这个链表：1->2->3->4->5
	
	当k= 2 时，应当返回: 2->1->4->3->5
	
	当k= 3 时，应当返回: 3->2->1->4->5
	
	
	
	说明：
	
	你的算法只能使用常数的额外空间。
	你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		int count = 0;
		ListNode nextHead = head;
		while (nextHead != null && count != k) {
			nextHead = nextHead.next;
			count++;
		}
		if (count == k) {
			//剩下节点继续，返回的是剩下节点排序好的head
			nextHead = reverseKGroup(nextHead, k);
			//      1,2,3   cur:4,5
			/*
				步骤：cur         head
					4,5          1,2,3
					1,4,5          2,3
				    2,1,4,5          3
				    3,2,1,4,5
			 */
			while (count != 0) {
				ListNode temp = head.next;
				head.next = nextHead;
				nextHead = head;
				head = temp;
				count--;
			}
			head = nextHead;
		}
		return head;
	}
	/*
		迭代实现
	 */

	public static ListNode reverseKGroup2(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;

		while (head != null) {
			ListNode tail = pre;
			// 查看剩余部分长度是否大于等于 k
			for (int i = 0; i < k; ++i) {
				tail = tail.next;
				if (tail == null) {
					return dummy.next;
				}
			}
			// 剩下的部分 4,5
			ListNode nex = tail.next;
			ListNode[] reverse = myReverse(head, tail);
			// 排序后的head，head=3,2,1
			head = reverse[0];
			// 排序后的tail,tail=1
			tail = reverse[1];
			// 把子链表重新接回原链表
			pre.next = head;
			// tail=1,4,5
			tail.next = nex;
			//pre=1，即后一段的head的前一个,pre的作用是为了链接下一段排序后的链表，跟初始的dummy含义相同，其实这里也可以参考递归方法里面的原地翻转实现，
			pre = tail;
			// head=4
			head = tail.next;
		}

		return dummy.next;
	}
	// 这里其实可以断开，再来反转会好理解点，看234题的reverse
	public static ListNode[] myReverse(ListNode head, ListNode tail) {
		ListNode prev = tail.next;
		ListNode p = head;
		while (prev != tail) {
			ListNode nex = p.next;
			p.next = prev;
			prev = p;
			p = nex;
		}
		return new ListNode[]{tail, head};
	}

	public static void main(String[] args) {
		System.out.println(reverseKGroup2(ListNode.build("[1,2,3,4,5]"), 3));
	}
}
