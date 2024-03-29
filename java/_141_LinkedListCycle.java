/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._141_LinkedListCycle
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.HashSet;
import java.util.Set;

/**
 *  环形链表
 * @author lilin
 * @date 2020-12-28 14:51
 */
public class _141_LinkedListCycle {
	/*
	给定一个链表，判断链表中是否有环。

	如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
	为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
	
	如果链表中存在环，则返回 true 。 否则，返回 false 。

	进阶：
	
	你能用 O(1)（即，常量）内存解决此问题吗？

	示例 1：

	输入：head = [3,2,0,-4], pos = 1
	输出：true
	解释：链表中有一个环，其尾部连接到第二个节点。
	示例2：

	输入：head = [1,2], pos = 0
	输出：true
	解释：链表中有一个环，其尾部连接到第一个节点。
	示例 3：

	输入：head = [1], pos = -1
	输出：false
	解释：链表中没有环。
	
	提示：
	
	链表中节点的数目范围是 [0, 104]
	-105 <= Node.val <= 105
	pos 为 -1 或者链表中的一个 有效索引 。
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/linked-list-cycle
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	链表相关 总结！
	https://leetcode-cn.com/problems/linked-list-cycle/solution/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-2/
	 */

	public static boolean hasCycle(ListNode head) {
		Set<ListNode> seen = new HashSet<>();
		while (head != null) {
			if (!seen.add(head)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	public static boolean hasCycle3(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}


}
