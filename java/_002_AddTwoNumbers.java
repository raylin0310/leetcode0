/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._002_AddTwoNumbers
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 两数相加
 * @author lilin
 * @date 2020-12-29 16:58
 */
public class _002_AddTwoNumbers {
	/*
	给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。

	如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	
	您可以假设除了数字 0 之外，这两个数都不会以 0开头。
	
	示例：
	
	输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	输出：7 -> 0 -> 8
	原因：342 + 465 = 807
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/add-two-numbers
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int p = 0;
		while (l1 != null || l2 != null) {
			int sum = p;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			p = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
		}
		// 末尾进
		if (p != 0) {
			cur.next = new ListNode(p);
		}
		return dummy.next;
	}


	public static void main(String[] args) {
		System.out.println(addTwoNumbers(ListNode.build("[2,4,3]"), ListNode.build("[5,6,4]")));
	}
}
