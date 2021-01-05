/*
 * @projectName leetcode0
 * @package PACKAGE_NAME
 * @className PACKAGE_NAME._135_MinStack
 * @copyright Copyright 2018 Thunisoft, Inc. All rights reserved.
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最小栈
 * @author lilin
 * @date 2021-1-5 14:39
 */
public class _155_MinStack {
	/*
	设计一个支持 push ，pop ，top 操作，并能在【常数时间】内检索到最小元素的栈。

	push(x) —— 将元素 x 推入栈中。
	pop()—— 删除栈顶的元素。
	top()—— 获取栈顶元素。
	getMin() —— 检索栈中的最小元素。
	
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/min-stack
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	static class MinStack {
		Deque<Integer> xStack;
		Deque<Integer> minStack;

		public MinStack() {
			xStack = new LinkedList<>();
			minStack = new LinkedList<>();
			minStack.push(Integer.MAX_VALUE);
		}

		public void push(int x) {
			xStack.push(x);
			minStack.push(Math.min(minStack.peek(), x));
		}

		public void pop() {
			xStack.pop();
			minStack.pop();
		}

		public int top() {
			return xStack.peek();
		}

		public int getMin() {
			return minStack.peek();
		}
	}
	/*
		push的时候，如果当前是最小的，就把上一个最小的值先push进去
		这样做的目的是在pop出最小的时候，能马上获取到第二小的值，紧挨着
	 */

	static class MinStack2 {
		int min = Integer.MAX_VALUE;
		Stack<Integer> stack = new Stack<>();

		public void push(int x) {
			// only push the old minimum value when the current
			// minimum value changes after pushing the new value x
			if(x <= min){
				stack.push(min);
				min=x;
			}
			stack.push(x);
		}

		public void pop() {
			// if pop operation could result in the changing of the current minimum value,
			// pop twice and change the current minimum value to the last minimum value.
			if(stack.pop() == min) {
				min=stack.pop();
			}
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return min;
		}
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(100);
		minStack.push(90);
		minStack.push(50);
		minStack.push(120);
		minStack.push(40);
		minStack.push(60);
		minStack.pop();
		minStack.pop();
		minStack.pop();
		minStack.pop();
	}
}
