package swordOffer;

import java.util.Stack;

public class _入栈弹栈 {

	/*
	输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
	假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
	但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

	解体思路：模仿入栈操作，当入栈的栈顶num 等于 出栈数组的index时，说明这时候已经出栈了
	以上面为例，依次入栈1，2，3，4，此时4等于pop[0]，说明当4入栈后，下一步就是出栈了
	此时栈顶元素是3，不等于pop[1]=5，所以继续入栈5->1,2,3,5

	 */

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> assistant = new Stack<Integer>();
		int index = 0;//用于标识弹出序列位置
		for (int i = 0; i < pushA.length; i++) {
			assistant.push(pushA[i]);
			//如果栈不为空，且栈顶元素等于弹出序列
			while (!assistant.isEmpty() && assistant.peek() == popA[index]) {
				assistant.pop();
				index += 1;//弹出序列后移
			}
		}

		return assistant.isEmpty();
	}

	public static void main(String[] args) {
		int[] pushA = {1, 2, 3, 4, 5};
		int[] popA = {4, 5, 3, 2, 1};
		int[] popB = {4, 3, 5, 1, 2};

		System.out.println(IsPopOrder(pushA,popA));
	}
}
