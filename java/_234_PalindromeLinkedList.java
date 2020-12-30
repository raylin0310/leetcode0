/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._234_PalindromeLinkedList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * @author lilin
 * @date 2020-12-30 10:00
 */
public class _234_PalindromeLinkedList {
	/*
	请判断一个链表是否为回文链表。

	示例 1:
	
	输入: 1->2
	输出: false
	示例 2:
	
	输入: 1->2->2->1
	输出: true
	进阶：
	你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/palindrome-linked-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	/*
	time:  O(n)
	space: O(1)
	会修改原链表，还有一种方法，顺序遍历链表，存入list中，遍历完后，双指针遍历list，就像125题那样，这种不会有并发危险，而且不会修改原链表
	 */

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode mid = findMid(head);
		mid.next = reverse(mid.next);
		ListNode left = head;
		ListNode right = mid.next;
		while (left != null && right != null) {
			if (left.val != right.val) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}

	// 找中节点，如果是偶数个，中节点是偏左

	public static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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

	/*
		space:O(n)
		不会修改原链表，也不存在并发安全
	 */

	public static boolean isPalindrome2(ListNode head) {
		List<Integer> vals = new ArrayList<>();
		// 将链表的值复制到数组中
		ListNode currentNode = head;
		while (currentNode != null) {
			vals.add(currentNode.val);
			currentNode = currentNode.next;
		}

		// 使用双指针判断是否回文
		int front = 0;
		int back = vals.size() - 1;
		while (front < back) {
			if (!vals.get(front).equals(vals.get(back))) {
				return false;
			}
			front++;
			back--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(ListNode.build("[1,2,2,1]")));
		System.out.println(isPalindrome(ListNode.build("[1,2,3,4]")));
		System.out.println(isPalindrome(ListNode.build("[1,2,3,4,5]")));
	}
}
