/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._147_InsertionSortList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 对链表进行插入排序
 * @author lilin
 * @date 2020-12-31 14:31
 */
public class _147_InsertionSortList {
	/*
	插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
	每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

	插入排序算法：
	
	插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
	每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
	重复直到所有输入数据插入完为止。

	示例 1：
	
	输入: 4->2->1->3
	输出: 1->2->3->4
	示例2：
	
	输入: -1->5->3->4->0
	输出: -1->0->3->4->5
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/insertion-sort-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val <= cur.next.val) {
				cur = cur.next;
			} else {
				//把next摘出来，
				ListNode temp = cur.next;
				cur.next = temp.next;
				// 比如prev=[0,2,5,8] temp=[3]，我们要找到节点2，把3放到2、5节点之间
				ListNode prev = dummy;
				while (prev.next.val <= temp.val) {
					prev = prev.next;
				}
				temp.next = prev.next;
				prev.next = temp;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		System.out.println(insertionSortList(ListNode.build("[10,8,5,7]")));
	}

}
