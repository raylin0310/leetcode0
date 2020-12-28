/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME.ListNode
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Arrays;

/**
 * ListNode
 * @author lilin
 * @date 2020-11-26 14:46
 */
public class ListNode {

	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		builder.append(val);
		ListNode n = next;
		while (n != null) {
			builder.append(",").append(n.val);
			n = n.next;
		}
		builder.append("]");
		return builder.toString();
	}

	public static ListNode build(String input) {

		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		int[] nums = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
		return build(nums);
	}

	public static ListNode build(int[] nums) {
		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for(int item : nums) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.build("[1,2,3,4,5,6,7,8,9]");
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		System.out.println(pre);
	}
}
