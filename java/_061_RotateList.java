/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._061_RotateList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 旋转链表
 * @author lilin
 * @date 2020-12-31 10:10
 */
public class _061_RotateList {
	/*
	给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。

	示例1:
	
	输入: 1->2->3->4->5->NULL, k = 2
	输出: 4->5->1->2->3->NULL
	解释:
	向右旋转 1 步: 5->1->2->3->4->NULL
	向右旋转 2 步: 4->5->1->2->3->NULL
	示例2:
	
	输入: 0->1->2->NULL, k = 4
	输出: 2->0->1->NULL
	解释:
	向右旋转 1 步: 2->0->1->NULL
	向右旋转 2 步: 1->2->0->NULL
	向右旋转 3 步:0->1->2->NULL
	向右旋转 4 步:2->0->1->NULL
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/rotate-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 找到要断开的位置断开，把右边的接到左边的前面即可
	 */

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		// 节点数量
		int n = 0;
		// 最右边的节点
		ListNode end = head;
		ListNode p = head;
		while (p != null) {
			end = p;
			p = p.next;
			n++;
		}
		int offset = k % n;
		if (offset == 0) {
			return head;
		}
		ListNode left = head;
		// 1,2,3,4,5  offset =1 循环三次，此时left=[4,5]
		for (int i = 0; i < n - offset - 1; i++) {
			left = left.next;
		}
		// right = [4,5]
		ListNode right = left.next;
		//从left断开
		left.next = null;
		// 把end放到head前面
		end.next = head;
		return right;
	}
	/*
	  先接上再断开
	 */

	public static ListNode rotateRight2(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode index = head;
		int len = 1;
		while (index.next != null) {
			index = index.next;
			len++;
		}
		index.next = head;
		// i<3
		for (int i = 1; i < len - k % len; i++) {
			head = head.next;
		}
		ListNode res = head.next;
		head.next = null;
		return res;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.build("[1,2,3,4,5]");
		System.out.println(rotateRight(head, 1));
	}
}
