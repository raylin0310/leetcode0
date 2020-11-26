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
		ListNode left = new ListNode();
		for (int num : nums) {
			left.next = new ListNode(num);
		}
		return left;
	}
}
