/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._328_OddEvenLinkedList
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

/**
 * 奇偶链表
 * @author lilin
 * @date 2020-12-28 19:15
 */
public class _328_OddEvenLinkedList {
	/*
	给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

	请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

	示例 1:

	输入: 1->2->3->4->5->NULL
	输出: 1->3->5->2->4->NULL
	示例 2:

	输入: 2->1->3->5->6->4->7->NULL
	输出: 2->3->6->7->1->5->4->NULL
	说明:

	应当保持奇数节点和偶数节点的相对顺序。
	链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。

	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/odd-even-linked-list
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
		 */

	/*
	time:O(n)
	space:O(1)
	 */

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		//这里的oddHead就是head
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		// 1,2,3,4,5,6,7
		while (even != null && even.next != null) {
			/*
			   1->
			      3->4->5->6->7
			   2->
			 */
			odd.next = odd.next.next;
			/*
			   1-> 3->4->5->6->7
			   2-> 4->5->6->7
			 */
			even.next = even.next.next;
			// odd = [3,4,5,6,7]
			odd = odd.next;
			// even = [4,5,6,7]
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static ListNode oddEvenList3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return odd;
	}

	public static ListNode oddEvenList2(ListNode head) {
		// 分别定义奇偶链表的 虚拟头结点 和 尾结点
		ListNode oddHead = new ListNode();
		ListNode oddTail = oddHead;
		ListNode evenHead = new ListNode();
		ListNode evenTail = evenHead;
		// 遍历原链表，根据 isOdd 标识位决定将当前结点插入到奇链表还是偶链表（尾插法）
		boolean isOdd = true;
		while (head != null) {
			if (isOdd) {
				oddTail.next = head;
				oddTail = oddTail.next;
			} else {
				evenTail.next = head;
				evenTail = evenTail.next;
			}
			head = head.next;
			isOdd = !isOdd;
		}
		// 将奇链表后面拼接上偶链表，并将偶链表的next设置为null
		oddTail.next = evenHead.next;
		evenTail.next = null;
		return oddHead.next;
	}

	public static void main(String[] args) {
		System.out.println(oddEvenList(ListNode.build("[1,2,3]")));
	}
}
