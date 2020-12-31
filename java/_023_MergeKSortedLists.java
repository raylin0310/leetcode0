/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._023_MergeKSortedLists
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 合并K个升序链表
 * @author lilin
 * @date 2020-12-31 13:43
 */
public class _023_MergeKSortedLists {
	/*
	给你一个链表数组，每个链表都已经按升序排列。

	请你将所有链表合并到一个升序链表中，返回合并后的链表。

	示例 1：
	
	输入：lists = [[1,4,5],[1,3,4],[2,6]]
	输出：[1,1,2,3,4,4,5,6]
	解释：链表数组如下：
	[
	  1->4->5,
	  1->3->4,
	  2->6
	]
	将它们合并到一个有序链表中得到。
	1->1->2->3->4->4->5->6
	示例 2：
	
	输入：lists = []
	输出：[]
	示例 3：
	
	输入：lists = [[]]
	输出：[]
	
	
	提示：
	
	k == lists.length
	0 <= k <= 10^4
	0 <= lists[i].length <= 500
	-10^4 <= lists[i][j] <= 10^4
	lists[i] 按 升序 排列
	lists[i].length 的总和不超过 10^4
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		return merge(lists, 0, lists.length - 1);
	}

	public static ListNode merge(ListNode[] lists, int l, int r) {
		if (l == r) {
			return lists[l];
		}
		int mid = l + (r - l) / 2;
		ListNode left = merge(lists, l, mid);
		ListNode right = merge(lists, mid + 1, r);
		return merge(left, right);
	}

	public static ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (a != null && b != null) {
			if (a.val < b.val) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		tail.next = (a != null ? a : b);
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode[] nodes = new ListNode[3];
		nodes[0] = ListNode.build("[1,2,3]");
		nodes[1] = ListNode.build("[7,8,9]");
		nodes[2] = ListNode.build("[4,5,6]");
		System.out.println(mergeKLists(nodes));
	}
}
