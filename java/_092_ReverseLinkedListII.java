/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._092_ReverseLinkedListII
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * _092_ReverseLinkedListII
 * @author lilin
 * @date 2020-12-28 20:05
 */
public class _092_ReverseLinkedListII {
	/*
	反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
	
	说明:
	1 ≤m≤n≤ 链表长度。
	
	示例:
	
	输入: 1->2->3->4->5->NULL, m = 2, n = 4
	输出: 1->4->3->2->5->NULL
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	参考这个题解，链表真是太难了
	https://github.com/grandyang/leetcode/issues/92
	 */

	public static ListNode reverseBetween2(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = dummy.next;
		for (int i = 1; i < m; i++) {
			cur = cur.next;
			pre = pre.next;
		}
		/*
		1 -> 2 -> 3 -> 4 -> 5 -> NULL  1

		1 -> 3 -> 2 -> 4 -> 5 -> NULL  2

		1 -> 4 -> 3 -> 2 -> 5 -> NULL  3

		1->2过程：pre=1,cur=2，现在的目的是把cur.next=3提出来，放到pre后面，就变成第2步
		2->3过程：pre=1,cur=2,现在把cur.next=4提出来，放到pre后面，
		 */
		for (int i = 0; i < n - m; i++) {
			// temp被提出来放到pre和pre.next之间
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		return dummy.next;
	}


	public static void main(String[] args) {
		System.out.println(reverseBetween2(ListNode.build("[1,2,3,4,5,6]"), 2, 5));
	}
}
