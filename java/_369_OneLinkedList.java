/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._369_OneLinkedList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _369_OneLinkedList
 * @author lilin
 * @date 2020-12-29 15:20
 */
public class _369_OneLinkedList {
	/*
	用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。

	你可以假设这个整数除了 0 本身，没有任何前导的 0。

	这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。

	示例:

	输入: [1,2,3]
	输出: [1,2,4]

	思路：找到最后一个不等于9的数i，
	比如  1,2,3,4,9,3  i=3
         2,9,9        i=2
         9,9,9        i=0(dummy)
      然后i.val++，i后面的数据置为0

	 */

	public static ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode i = dummy;
		ListNode j = dummy;

		while (j.next != null) {
			j = j.next;
			if (j.val != 9) {
				i = j;
			}
		}
		i.val++;
		i = i.next;
		while (i != null) {
			i.val = 0;
			i = i.next;
		}
		if (dummy.val == 0) {
			return dummy.next;
		}
		return dummy;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(plusOne(ListNode.build("[9,9,9]")));
	}

}
