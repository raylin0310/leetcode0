/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._237_DeleteNodeInALinkedList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 删除链表中的节点
 * @author lilin
 * @date 2020-12-29 11:11
 */
public class _237_DeleteNodeInALinkedList {
	/*
	请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
	示例 1：

	输入：head = [4,5,1,9], node = 5
	输出：[4,1,9]
	解释：给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
	示例 2：
	
	输入：head = [4,5,1,9], node = 1
	输出：[4,5,9]
	解释：给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

	提示：
	
	链表至少包含两个节点。
	链表中所有节点的值都是唯一的。
	给定的节点为非末尾节点并且一定是链表中的一个有效节点。
	不要从你的函数中返回任何结果。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {

	}
}
